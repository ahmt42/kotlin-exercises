package tojson

import com.fasterxml.jackson.databind.ObjectMapper
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File


/*
val url = "https://tr.linkedin.com/jobs/search?keywords=Android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r86400&position=1&pageNum=0"
val url = "https://tr.linkedin.com/jobs/search?keywords=Android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r86400" // son 24 saat
val url = "https://tr.linkedin.com/jobs/search?keywords=Android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r43200" // son 12 saat
val url = "https://tr.linkedin.com/jobs/search?keywords=Android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r21600" // son 6 saat
val url = "https://tr.linkedin.com/jobs/search?keywords=android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r3600" // son 1 saat
val url = "https://tr.linkedin.com/jobs/search?keywords=android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r115200" // son 32 saat
val url = "https://tr.linkedin.com/jobs/search?keywords=Android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r172800" // son 48 saat / 2 gün
val url = "https://tr.linkedin.com/jobs/search?keywords=Android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r259200" // son 72 saat / 3 gün
val url = "https://tr.linkedin.com/jobs/search?keywords=Android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r604800" // son 1 hafta / 7 gün
val url = "https://tr.linkedin.com/jobs/search?keywords=Android&location=Türkiye&locationId=&geoId=102105699&f_TPR=r2592000" // son 1 ay / 30 gün
*/


val inputFile = File("./files/ln_jobs_input.txt")
val outputFile = File("./files/ln_jobs_output.json")

fun main() {
    val html = inputFile.readText()
    val doc = Jsoup.parse(html)
    htmlListToJson(doc, outputFile)
}

fun htmlListToJson(doc: Document, jsonFile: File) {
    val data = mutableListOf<Map<String, String>>()

    val rows = doc.select("li")

    for (row in rows) {
        val obj = mutableMapOf<String, String>()

        val title = row.select("div.base-search-card__info")
            .select("h3")
            .text()
        val company = row.select("div.base-search-card__info")
            .select("h4 a")
            .text()
        val date = row.select("div.base-search-card__info div.base-search-card__metadata")
            .select("time")
            .attr("datetime")
        val link = row.select("div.base-card")
            .select("a.base-card__full-link")
            .attr("href")
            .split("?").get(0)

        var size = link.split("?").get(0).split("-").size
        var link_short = "https://www.linkedin.com/jobs/view/" + link.split("?").get(0).split("-").get(size-1).filter { it.isDigit() }

        obj["title"] = title
        obj["company"] = company
        obj["date"] = date
        obj["link"] = link
        obj["link-short"] = link_short

        val pattern = Regex("(android|kotlin|mobil)")
        val matches = pattern.findAll(title.lowercase())

        if (matches.toList().size > 0) {
            data.add(obj)
        }
    }


    data.sortWith(Comparator { a, b -> b["date"]!!.compareTo(a["date"]!!) }) // Sort by name key
    //data.sortWith(Comparator { a, b -> a["company"]!!.compareTo(b["company"]!!) }) // Sort by name key
    // Print the sorted list
    data.forEach { println(it) }

    val json = ObjectMapper().writeValueAsString(data)
    jsonFile.writeText(json)
}