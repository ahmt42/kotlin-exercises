/**
 * Bir dizinin ortalamasını bulun:
 */

fun main() {
    val numbers = listOf(71, 32, 13, 44, 67)
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    val average: Double = sum.toDouble() / numbers.size
    println(average)
}

/**
 * Bu kod, bir dizi oluşturur ve o dizideki tüm sayıların toplamını bulur. Daha sonra, ortalama değeri dizinin boyutu ile böler ve sonuçu ekrana yazdırır.
 */