fun main() {
    val number = 83

    when {
        isPrime(number) -> println("$number is a prime number.")
        else -> println("$number is not a prime number.")
    }
}

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}