package org.example


/**
 * 첫번째 해결 방법
 * 시간복잡도 만족 X
 */
class LeetCode4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        val nums = (nums1 + nums2).sorted()
        val middle = (m + n) / 2

        return if ((m + n) % 2 == 1) {
            nums[middle].toDouble()
        } else {
            val result = (nums[middle - 1] + nums[middle]) / 2.0
            result
        }

    }
}
