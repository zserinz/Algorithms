package stack_queue

import java.util.ArrayDeque
import java.util.Deque

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack: Deque<Char> = java.util.ArrayDeque()
        val table: Map<Char, Char> = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        for (i in s.indices) {
            if (!table.containsKey(s[i])) {
                stack.push(s[i])
            } else if (stack.isEmpty() || table[s[i]] !== stack.pop()) {
                return false
            }
        }
        return stack.size == 0
    }
}