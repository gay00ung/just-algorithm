class LeetCode20 {
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()

        for (ch in s) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.add(ch)
            } else {
                if (stack.isEmpty()) {
                    return false
                }
                val last = stack.removeAt(stack.lastIndex)

                if (ch == ')' && last != '(') {
                    return false
                }
                if (ch == ']' && last != '[') {
                    return false
                }
                if (ch == '}' && last != '{') {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}
