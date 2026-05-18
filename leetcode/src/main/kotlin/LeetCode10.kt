class LeetCode10 {
    fun isMatch(s: String, p: String): Boolean {
        // 이미 계산한 dp(i, j) 결과를 저장하는 HashMap
        // key = Pair(i, j)
        // value = s의 i번째부터와 p의 j번째부터가 매칭되는지 여부
        val memo = HashMap<Pair<Int, Int>, Boolean>()

        // dp(i, j)의 의미:
        // s[i...] 와 p[j...] 가 서로 매칭되는가?
        fun dp(i: Int, j: Int): Boolean {
            // 현재 상태를 key로 만듦
            // 예: i = 2, j = 3이면 "s[2...]와 p[3...] 비교 결과"
            val key = i to j // Pair(i, j) 와 동일

            // 이미 같은 상태를 계산한 적이 있으면
            // 다시 계산하지 않고 저장된 결과를 바로 반환
            memo[key]?.let { return it }

            // 패턴 p를 끝까지 다 사용한 경우
            if (j == p.length) {
                // 문자열 s도 끝까지 다 사용했으면 true
                // s가 아직 남아 있으면 false
                return i == s.length
            }

            // 현재 s[i]와 p[j]가 매칭되는지 확인
            // 단, i가 s.length보다 작아야 s[i]에 접근 가능
            // p[j]가 s[i]와 같거나, p[j]가 '.'이면 매칭
            val firstMatch = i < s.length && (s[i] == p[j] || p[j] == '.')

            // 현재 패턴 문자 다음에 '*'가 있는지 확인
            val result = if (j + 1 < p.length && p[j + 1] == '*') {

                // p[j + 1]이 '*'라는 뜻은
                // 현재 패턴이 p[j]* 형태라는 뜻
                //
                // 예:
                // p[j] = 'a'
                // p[j + 1] = '*'
                // 그러면 "a*"를 처리하는 상황

                // 경우 1:
                // p[j]*를 0개로 처리함
                // 즉, 이 패턴 묶음을 아예 안 쓰고 건너뜀
                //
                // dp(i, j + 2)
                // s는 그대로 두고, p만 두 칸 이동
                //
                // 예:
                // s = "aab"
                // p = "c*a*b"
                // 처음 c*는 0개로 처리 가능하므로
                // p에서 c*를 건너뛰고 a*b로 이동

                // 경우 2:
                // 현재 문자가 매칭된다면 p[j]*가 s[i] 하나를 먹음
                //
                // firstMatch && dp(i + 1, j)
                //
                // s는 한 칸 이동하지만, p는 그대로 j에 머무름
                // 왜냐하면 '*'는 같은 문자를 여러 개 먹을 수 있기 때문
                //
                // 예:
                // s = "aaab"
                // p = "a*b"
                // a*가 첫 번째 a를 먹은 뒤에도
                // 아직 a*로 두 번째 a, 세 번째 a를 더 먹을 수 있음

                dp(i, j + 2) || (firstMatch && dp(i + 1, j))
            } else {

                // 다음 문자가 '*'가 아닌 경우
                // 즉, 일반 문자 하나 또는 '.' 하나를 처리하는 상황
                //
                // 현재 문자가 매칭되면
                // s와 p를 둘 다 한 칸씩 이동
                //
                // 예:
                // s = "abc"
                // p = "a.c"
                // a와 a가 맞으면
                // 다음은 s[1]과 p[1] 비교

                firstMatch && dp(i + 1, j + 1)
            }

            // 현재 상태 dp(i, j)의 결과를 memo에 저장
            memo[key] = result

            // 계산한 결과 반환
            return result
        }

        // 처음부터 비교 시작
        // s[0...] 와 p[0...] 가 매칭되는지 확인
        return dp(0, 0)
    }
}
