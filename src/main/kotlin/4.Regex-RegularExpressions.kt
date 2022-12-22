fun main() {
    val input = "My email is example@gmail.com and my friend's email is friend@yahoo.com"
    val pattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b"
    val regex = Regex(pattern)
    val matches = regex.findAll(input)

    for (match in matches) {
        println(match.value)
    }
}