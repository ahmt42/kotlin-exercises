import kotlin.system.measureTimeMillis

// iki sayı arasındaki asal sayıyı bul ve gecen süreyi hesapla

fun main() {
    findPrimeNumbers(1, 100000)
}

/*
fun isPrime(number: Int): Boolean {
    if (number < 2) return false
    for (i in 2 until number) {
        if (number % i == 0) return false
    }
    return true
}
*/

fun findPrimeNumbers(start: Int, end: Int) {
    val elapsedTime = measureTimeMillis {
        for (number in start..end) {
            if (isPrime(number)) {
                print("$number ")
            }
        }
    }
    println("\nElapsed time: $elapsedTime ms")
}

/*
fun findPrimeNumbers(start: Int, end: Int) {
    val elapsedTime = measureTimeMillis {
        for (number in start..end) {
            when {
                isPrime(number) -> print("$number ")
            }
        }
    }
    println("\nElapsed time: $elapsedTime ms")
}
*/
