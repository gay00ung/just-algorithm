import kotlin.math.abs

class LeetCode16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var closestSum = nums[0] + nums[1] + nums[2]
        var closestDiff = abs(closestSum - target)

        for (i in 0 until nums.size - 2) {
            var left = i + 1
            var right = nums.lastIndex

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]
                val diff = abs(sum - target)

                if (diff < closestDiff) {
                    closestDiff = diff
                    closestSum = sum
                }

                if (sum < target) {
                    left++
                } else if (sum > target) {
                    right--
                } else {
                    return sum
                }
            }
        }
        return closestSum
    }
}
