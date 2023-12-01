package stack_queue

/**
 * Design your implementation of the circular queue.
 * The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle,
 * and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 *
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue.
 * In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue.
 * But using the circular queue, we can use the space to store new values.
 */
class DesignCircularQueue {
    class MyCircularQueue(k: Int) {
        val q: IntArray = IntArray(k) // 원형 큐
        var front = 0 // 머리
        var rear = -1 // 꼬리(머리 한 칸 전)
        var len = 0 // 원형 큐의 길이

        // 엘리먼트 삽입
        fun enQueue(value: Int): Boolean {
            return if (!this.isFull()) {
                 // 엘리먼트가 새로 추가되었으므로, rear는 추가된 만큼 뒤로 이동하게 된다.
                this.rear = (this.rear + 1) % this.q.size
                this.q[rear] = value // 뒤에 새로운 값 추가
                this.len++ // 길이 증가
                true
            } else
            false
        }

        // 엘리먼트 삭제
        fun deQueue(): Boolean {
            return if (!this.isEmpty()) {
                // 엘리먼트가 앞에서부터 삭제된다.
                this.front = (this.front + 1) % this.q.size
                this.len--
                true
            } else
                false
        }

        fun Front(): Int {
            return if (this.isEmpty())
                -1
            else
                q[front] // 맨 앞 값
        }

        fun Rear(): Int {
            return if (this.isEmpty())
                -1
            else
                q[this.rear] // 맨 뒤 값
        }

        fun isEmpty(): Boolean {
            // 현재 큐의 크기가 0이면 비어있는 상태이다.
            return this.len == 0
        }

        fun isFull(): Boolean {
            // 현재 큐의 크기가 전체 큐의 크기와 일치하면 꽉 차 있는 상태이다.
            return this.len == this.q.size
        }
    }
}