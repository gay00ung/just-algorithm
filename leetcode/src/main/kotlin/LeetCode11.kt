class LeetCode11 {
    fun maxArea(height: IntArray): Int {
        var maxSize = 0
        var left = 0
        var right = height.lastIndex

        while (left < right) {
            val currentSize = minOf(height[left], height[right]) * (right - left)
            maxSize = maxOf(maxSize, currentSize)

            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }
        return maxSize
    }
}
