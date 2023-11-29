package stack_queue

import java.util.ArrayDeque
import java.util.Deque

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack: Deque<Char> = java.util.ArrayDeque()
        // 유효성 검증을 위한 매핑 테이블
        val table: Map<Char, Char> = mapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        for (i in s.indices) {
            if (!table.containsKey(s[i])) { // 닫힘 괄호가 아닌 경우 스택에 푸시
                stack.push(s[i])
            } else if (stack.isEmpty() || table[s[i]] !== stack.pop()) { // 괄호가 연속으로 존재하는 경우 제한
                return false
            }
        }
        return stack.size == 0 // 최종 결과가 반복 완료 이후에 비어있어야 한다.
    }
}