package stack_queue

import java.util.ArrayDeque
import java.util.Deque

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is
 * the smallest in lexicographical order
 *  among all possible results.
 */
class RemoveDuplicateLetters {
    fun removeDuplicateLetters(s: String): String {
        val counter: MutableMap<Char, Int> = HashMap() // 중복 카운트 -> 문자 개수를 계산해서 담아 둘 변수
        val seen: MutableMap<Char, Boolean> = HashMap() // 이미 처리한 문자 여부 선언
        val stack: Deque<Char> = java.util.ArrayDeque() // 문자를 쌓아 나갈 변수 -> 정답으로 제출할 변수

        for (c in s)
            counter[c] = counter.getOrDefault(c,0) + 1 // 문자별 개수 계산

        for (c in s) {
            counter[c] = counter[c]!! - 1 // 현재 처리하는 문자는 -1 처리
            if (seen[c] == true) // 이미 처리한 문자는 건너 뛰기
                continue
            while (!stack.isEmpty() && stack.peek() > c && counter[stack.peek()]!! > 0) // 현재 문자보다 더 뒤에 붙여야 할 문자이면 스택에서 제거하고 처리하지 않음 표시
                seen[stack.pop()] = false

            stack.push(c) // 현재 문자 스택에 삽입
            seen[c] = true // 현재 문자 처리한 것으로 선언
        }

        val sb = StringBuilder()
        while (!stack.isEmpty())
            sb.append(stack.pollLast()) // 스택에 있는 문자를 큐 순서대로 추출해서 선언

        return sb.toString()
    }
}