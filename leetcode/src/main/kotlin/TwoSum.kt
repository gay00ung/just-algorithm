package org.example

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val size = nums.size
        val array = arrayOfNulls<Int>(2)

        for (i in 0 until size - 1) {
            var a = nums[i]
            for (j in i + 1 until size) {
                var b = nums[j]
                if (a + b == target) {
                    array.set(0, i)
                    array.set(1, j)
                }
            }
        }
        return array.filterNotNull().toIntArray()
    }
}
