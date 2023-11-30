package stack_queue

import java.util.LinkedList
import java.util.Queue

/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 */
class ImplementStackUsingQueues {
    private val queue: Queue<Int> = LinkedList()
    fun push(x: Int) {
        queue.add(x) // 엘리먼트 삽입
        for (i in 1 until queue.size) // 맨 앞에 두고 전체 재정렬
            queue.add(queue.remove())
    }

    fun pop(): Int {
        return queue.remove() // 재정렬된 상태이므로 그대로 추출
    }

    fun top(): Int {
        return queue.peek() // 재정렬된 상태이므로 큐 연산으로 조회
    }

    fun empty(): Boolean {
        return queue.size == 0 // 크기를 비교하여 연산
    }
}