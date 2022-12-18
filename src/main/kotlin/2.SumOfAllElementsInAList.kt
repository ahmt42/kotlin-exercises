/**
 *  Bir liste içindeki tüm elemanların toplamını hesaplamak
 */


fun sumElements(elements: List<Int>): Int {
    return elements.reduce { acc, i -> acc + i }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    val sum = sumElements(numbers)
    println(sum)  // Output: 10
}

/**
 *  Bu kod, bir liste (elements) içindeki tüm elemanların toplamını hesaplamak için bir fonksiyon olarak yazılmıştır.
 *  Bu fonksiyon, reduce işlevini kullanarak, liste elemanlarını birbiriyle birleştirir ve bir tek değer olarak döndürür.
 *  Örneğin, bir liste olarak [1, 2, 3, 4] girdisi verildiğinde, fonksiyon 1 + 2 + 3 + 4 sonucunu döndürür ve 10 döndürür.
 */