class LeetCode14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.contains("")) {
            return ""
        } else if (strs.size == 1) {
            return strs[0]
        }

        for (i in strs[0].indices) {
            for (j in strs.indices) {
                if (i >= strs[j].length || strs[j][i] != strs[0][i]) {
                    // 처음 달라지면 그 인덱스 직전까지 return
                    return strs[0].substring(0, i)
                }
            }
        }
        return strs[0]
    }
}
