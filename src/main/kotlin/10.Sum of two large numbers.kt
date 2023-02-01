// Sum of two large numbers

fun main(args: Array<String>) {
    println(addNumbers("7777555511111111", "3332222221111"))
}

fun addNumbers(num1: String, num2: String): String {
    var result = ""
    var carry = 0
    var i = num1.length - 1
    var j = num2.length - 1
    while (i >= 0 || j >= 0) {
        var sum = carry
        if (i >= 0) {
            sum += num1[i].toInt() - '0'.toInt()
            i--
        }
        if (j >= 0) {
            sum += num2[j].toInt() - '0'.toInt()
            j--
        }
        carry = sum / 10
        result = (sum % 10).toString() + result
    }
    if (carry > 0) {
        result = carry.toString() + result
    }
    return result
}
