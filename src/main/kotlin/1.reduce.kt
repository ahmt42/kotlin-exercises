fun main() {
    /**
     * reduce fonksiyonu, bir dizinin elemanlarını birbirleriyle birleştirir ve sonucu bir tek değer olarak döndürür.
     * bu fonksiyon, bir dizinin elemanlarını bir başlangıç değeriyle birleştirir ve döndürdüğü değer, her bir elemanın birleştirilmesinden sonraki değerdir.
     *
     * reduce işlevi, aşağıdaki şekilde kullanılabilir:
     */

    val numbers = listOf(1, 2, 3, 4)
    val sum = numbers.reduce { acc, next -> acc + next }
    println(sum)  // Output: 10

    /**
     *  Bu örnekte, reduce işlevi, numbers dizisinin elemanlarını birleştirir ve 1 + 2 + 3 + 4 sonucunu döndürür, yani 10 döndürür.
     */
}

