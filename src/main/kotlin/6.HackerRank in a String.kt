// Verilen stringin içinde “hackerrank” yazılıp yazılmaması kontrolünü yapmamızı ve yazıyorsa “YES” yazmıyorsa “NO” dönmemiz isteniyor.


fun main() {
    println(inString("hereiamstackerrank"))
    println(inString("iamstackerrank"))
}
private fun inString(s: String): String {
    val hackerrankString = "hackerrank"

    if (s.length < hackerrankString.length) {
        return "NO"
    }

    var index = 0
    for (element in s) {
        if (index < hackerrankString.length && element == hackerrankString[index]) {
            index++
        }
    }
    return if (index == hackerrankString.length) "YES" else "NO"
}