// How to find duplicate number on Integer array

fun main() {
    val nums = intArrayOf(1, 2, 3, 4, 5, 5, 6, 7, 8, 9)
    val duplicates = findDuplicates(nums)
    println("Duplicate numbers in the array: $duplicates")
}

fun findDuplicates(nums: IntArray): List<Int> {
    val duplicates = mutableListOf<Int>()
    val set = hashSetOf<Int>()
    for (num in nums) {
        if (!set.add(num)) {
            duplicates.add(num)
        }
    }
    return duplicates
}