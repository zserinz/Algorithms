package stack_queue

import java.util.ArrayDeque
import java.util.Deque

/**
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 *
 * Implement the MyQueue class:
 *
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 */
class ImplementQueueUsingStacks {
    private val input: Deque<Int> = ArrayDeque()
    private val output = ArrayDeque<Int>()
    fun push(x: Int) {
        input.push(x)
    }

    fun pop(): Int {
        peek() // 비어있으면 처리
        return output.pop() // 추출 스택의 맨 마지막 값 추출
    }

    fun peek(): Int {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop())
            }
        }
        return output.peek()
    }

    fun empty(): Boolean {
        return input.isEmpty() && output.isEmpty()
    }
}