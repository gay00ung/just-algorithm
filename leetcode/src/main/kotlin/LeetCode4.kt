package org.example


/**
 * 첫 번째 해결 방법
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

/**
 * 두 번째 해결 방법: 이분 탐색을 이용한 중앙값 찾기
 *
 * 두 배열 nums1, nums2는 이미 정렬되어 있다고 가정한다.
 * 전체 배열을 직접 합치거나 다시 정렬하지 않고,
 * 두 배열을 각각 적절한 위치에서 잘라서
 * 왼쪽 절반과 오른쪽 절반을 만든다.
 *
 * 올바른 분할 조건은 다음과 같다.
 *
 * left1 <= right2 && left2 <= right1
 *
 * 위 조건이 만족되면 왼쪽 절반의 모든 값은
 * 오른쪽 절반의 모든 값보다 작거나 같으므로,
 * 중앙값을 바로 계산할 수 있다.
 *
 * - 전체 길이가 홀수인 경우:
 *   왼쪽 절반이 오른쪽 절반보다 하나 더 많도록 만들기 때문에
 *   왼쪽 절반의 최댓값이 중앙값이 된다.
 *
 * - 전체 길이가 짝수인 경우:
 *   왼쪽 절반의 최댓값과 오른쪽 절반의 최솟값의 평균이 중앙값이 된다.
 *
 * 시간복잡도: O(log(min(m, n)))
 * 공간복잡도: O(1)
 */
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // 이분 탐색은 더 짧은 배열을 기준으로 해야 cut2가 범위를 벗어나지 않음
        // nums1이 nums2보다 길면 두 배열의 순서를 바꿔서 다시 함수 실행
        if (nums1.size > nums2.size) {
            return findMedianSortedArrays(nums2, nums1)
        }

        // nums1의 길이
        val m = nums1.size

        // nums2의 길이
        val n = nums2.size

        // nums1에서 자를 수 있는 최소 위치
        // cut1 = 0이면 nums1에서 왼쪽 부분으로 가져오는 값이 없다는 뜻
        var left = 0

        // nums1에서 자를 수 있는 최대 위치
        // cut1 = m이면 nums1 전체를 왼쪽 부분으로 가져온다는 뜻
        var right = m

        // left가 right보다 커지기 전까지 이분 탐색 반복
        while (left <= right) {
            // nums1을 자를 위치
            // nums1에서 왼쪽 부분으로 cut1개를 가져옴
            val cut1 = (left + right) / 2

            // nums2를 자를 위치
            // 전체 왼쪽 부분의 개수를 (m + n + 1) / 2개로 맞추기 위해 계산
            val cut2 = (m + n + 1) / 2 - cut1

            // nums1의 왼쪽 부분에서 가장 오른쪽 값
            // cut1이 0이면 nums1 왼쪽 부분이 비어 있으므로 가장 작은 값으로 처리
            val left1 = if (cut1 == 0) Int.MIN_VALUE else nums1[cut1 - 1]

            // nums1의 오른쪽 부분에서 가장 왼쪽 값
            // cut1이 m이면 nums1 오른쪽 부분이 비어 있으므로 가장 큰 값으로 처리
            val right1 = if (cut1 == m) Int.MAX_VALUE else nums1[cut1]

            // nums2의 왼쪽 부분에서 가장 오른쪽 값
            // cut2가 0이면 nums2 왼쪽 부분이 비어 있으므로 가장 작은 값으로 처리
            val left2 = if (cut2 == 0) Int.MIN_VALUE else nums2[cut2 - 1]

            // nums2의 오른쪽 부분에서 가장 왼쪽 값
            // cut2가 n이면 nums2 오른쪽 부분이 비어 있으므로 가장 큰 값으로 처리
            val right2 = if (cut2 == n) Int.MAX_VALUE else nums2[cut2]

            // 올바르게 잘린 상태인지 확인
            // 왼쪽 부분의 모든 값이 오른쪽 부분의 모든 값보다 작거나 같아야 함
            if (left1 <= right2 && left2 <= right1) {
                // 전체 길이가 홀수인 경우
                return if ((m + n) % 2 == 1) {
                    // 홀수일 때는 왼쪽 부분이 오른쪽보다 하나 더 많음
                    // 따라서 왼쪽 부분의 최댓값이 중앙값
                    maxOf(left1, left2).toDouble()
                } else {
                    // 전체 길이가 짝수인 경우
                    // 왼쪽 부분의 최댓값과 오른쪽 부분의 최솟값의 평균이 중앙값
                    (maxOf(left1, left2).toDouble() + minOf(right1, right2).toDouble()) / 2.0
                }

                // nums1의 왼쪽 값이 nums2의 오른쪽 값보다 크면
                // nums1에서 왼쪽으로 너무 많이 가져온 상태
            } else if (left1 > right2) {
                // cut1을 줄이기 위해 탐색 범위를 왼쪽으로 이동
                right = cut1 - 1

                // 그 외의 경우는 left2 > right1인 상태
                // nums1에서 왼쪽으로 너무 적게 가져온 상태
            } else {
                // cut1을 늘리기 위해 탐색 범위를 오른쪽으로 이동
                left = cut1 + 1
            }
        }

        // 문제 조건상 정상 입력이면 여기까지 오지 않음
        // Kotlin에서는 반환값이 필요하므로 예외적으로 0.0 반환
        return 0.0
    }
}
