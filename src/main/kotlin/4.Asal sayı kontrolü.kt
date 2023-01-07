fun main() {
    val number = 83

    when {
        isPrime(number) -> println("$number is a prime number.")
        else -> println("$number is not a prime number.")
    }

    // 1'den 100'e kadar asal sayılar
    print("1'den 100'e kadar asal sayılar sırasıyla şu şekildedir :")
    for (i in 1..100) {
        if (isPrime(i)) {
            print("$i ")
        }
    }

}

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}