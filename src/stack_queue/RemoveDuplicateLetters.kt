package stack_queue

import java.util.ArrayDeque
import java.util.Deque

class RemoveDuplicateLetters {
    fun removeDuplicateLetters(s: String): String {
        val counter: MutableMap<Char, Int> = HashMap()
        val seen: MutableMap<Char, Boolean> = HashMap()
        val stack: Deque<Char> = java.util.ArrayDeque()

        for (c in s)
            counter[c] = counter.getOrDefault(c,0) + 1

        for (c in s) {
            counter[c] = counter[c]!! - 1
            if (seen[c] == true)
                continue
            while (!stack.isEmpty() && stack.peek() > c && counter[stack.peek()]!! > 0)
                seen[stack.pop()] = false

            stack.push(c)
            seen[c] = true
        }

        val sb = StringBuilder()
        while (!stack.isEmpty())
            sb.append(stack.pollLast())

        return sb.toString()
    }
}