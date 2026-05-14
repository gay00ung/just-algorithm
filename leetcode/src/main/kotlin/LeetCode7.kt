/**
 * 처음 풀었던 방법에서는 reversed가 MIN 혹은 MAX보다 큰지 체크하는 부분이 없어서,
 * 예를들어 1534236469 같은 경우에 overflow가 발생
 *
 * 그래서 reversed가 MIN 혹은 MAX보다 큰지 체크하는 부분을 추가함
 */
class Solution {
    fun reverse(x: Int): Int {
        if (x < Int.MIN_VALUE || x > Int.MAX_VALUE || x == 0) {
            return 0
        }

        val reversed =
            if (x > 0) x.toString().reversed().toLong()
            else -x.toString().drop(1).reversed().toLong()

        if (reversed > Int.MAX_VALUE || reversed < Int.MIN_VALUE) {
            return 0
        } else {
            return reversed.toInt()
        }
    }
}
