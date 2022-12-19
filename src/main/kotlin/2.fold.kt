fun main() {

    /**
     *  old işlevi, bir dizinin elemanlarını birbirleriyle birleştirir ve sonucu bir tek değer olarak döndürür.
     *  Bu işlev, bir dizinin elemanlarını bir başlangıç değeriyle birleştirir ve döndürdüğü değer, her bir elemanın birleştirilmesinden sonraki değerdir.
     *
     *  fold işlevi, aşağıdaki şekilde kullanılabilir:
     */

    val numbers = listOf(1, 2, 3, 4)
    val sum = numbers.fold(100) { total, next -> total + next }
    println(sum)  // Output: 110

    /**
     * Bu örnekte, fold işlevi, numbers dizisinin elemanlarını 100 ile birleştirir ve 100 + 1 + 2 + 3 + 4 sonucunu döndürür, yani 110 döndürür.
     */

}