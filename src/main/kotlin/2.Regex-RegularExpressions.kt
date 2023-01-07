/**
 *   Verilen bir dizge içinde, geçerli bir eposta adresini bulma.
 */

fun main() {
    val input = "My email is example@gmail.com and my friend's email is friend@yandex.com"
    val pattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b"
    val regex = Regex(pattern)
    val matches = regex.findAll(input)

    for (match in matches) {
        println(match.value)
    }
}

/**
 *   Bu kod, verilen input dizesinde geçerli olan tüm eposta adreslerini bulur ve ekrana yazdırır.
 *   Örneğin, bu kod çalıştırıldığında, example@gmail.com ve friend@yahoo.com değerleri ekrana yazdırılır.
 *
 *   Regex (Regular Expression) ifadeleri, verilen bir dize içinde belirli bir şablonu aramanıza yardımcı olan araçlardır.
 *   Bu örnekte, \\b ifadesi dize sınırlarını,
 *   [A-Za-z0-9._%+-]+ ifadesi eposta adresinin kullanılabilecek tüm karakterleri (harfler, sayılar ve özel karakterler),
 *   @ ifadesi eposta adresinin ayrılış noktasını,
 *   [A-Za-z0-9.-]+ ifadesi eposta adresinin domain adının kullanılabilecek tüm karakterlerini ve
 *   \\.[A-Za-z]{2,} ifadesi de domain adının uzantısını belirtir.
 *   Bu ifadeler birlikte, verilen dizede geçerli olan tüm eposta adreslerini aramaya yarar.
 */