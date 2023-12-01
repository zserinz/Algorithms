package deque

/**
 * Design your implementation of the circular double-ended queue (deque).
 *
 * Implement the MyCircularDeque class:
 *
 * MyCircularDeque(int k) Initializes the deque with a maximum size of k.
 * boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
 * boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
 * int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
 * int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
 * boolean isEmpty() Returns true if the deque is empty, or false otherwise.
 * boolean isFull() Returns true if the deque is full, or false otherwise.
 *
 */
class DesignCircularDeque {
    class MyCircularDeque(k: Int) {
        data class DoublyLinkedList(var `val`: Int) {
            var left: DoublyLinkedList? = null // 왼쪽으로 연결할 이중 연결 리스트
            var right: DoublyLinkedList? = null // 오른쪽으로 연결할 이중 연결 리스트
        }

        var len = 0 // 현재 큐의 크기
        var k = 0 // 전체 큐의 크기
        var head: DoublyLinkedList? = null // 이중 연결 리스트 head 노드
        var tail: DoublyLinkedList? = null // 이중 연결 리스트 tail 노드

        init {
            head = DoublyLinkedList(0)
            tail = DoublyLinkedList(0)

            head!!.right = tail
            tail!!.left = head

            this.k = k
            len = 0
        }

        /**
         * 이중 연결 리스트의 노드에 신규 노드를 삽입하는 과정
         * 1. head - tail 연결 고리를 삭제한다.
         * 2. head - node 헤드 오른쪽에 신규 노드를 추가한다
         * 3. node - tail 테일 왼쪽에 신규 노드를 추가한다.
         *    즉, head - node - tail 형태로 서로 마주보도록 설정한다.
         */
        // 데크 처음에 아이템 추가
        fun insertFront(value: Int): Boolean {
            if (isFull())
                return false
            val node = DoublyLinkedList(value)
            // head - node 신규 노드는 헤드 바로 오른쪽에 삽입
            node.right = head!!.right
            node.left = head
            head!!.right!!.left = node
            head!!.right = node
            len++
            return true
        }

        // 데크 마지막에 아이템 추가
        fun insertLast(value: Int): Boolean {
            if (isFull())
                return false
            val node = DoublyLinkedList(value)
            // node - tail 신규 노드는 테일 바로 왼쪽에 삽입
            node.left = tail!!.left
            node.right = tail
            tail!!.left!!.right = node
            tail!!.left = node
            len++
            return true
        }

        // 데크 처음에 아이템 삭제
        fun deleteFront(): Boolean {
            if (isFull())
                return false
            // head 바로 오른쪽 노드를 연결에서 끊음
            head!!.right!!.right!!.left = head
            head!!.right = head!!.right!!.right
            len--
            return true
        }

        // // 데크 마지막에 아이템 삭제
        fun deleteLast(): Boolean {
            if (isFull())
                return false
            // tail 바로 왼쪽 노드를 연결에서 끊음
            tail!!.left!!.left!!.right = tail
            tail!!.left = tail!!.left!!.left
            len--
            return true
        }

        // 첫 번째 아이템 가져오기
        fun getFront(): Int {
            return if (isEmpty()) -1 else head!!.right!!.`val`
        }

        // 마지막 아이템 가져오기
        fun getRear(): Int {
            return if (isEmpty()) -1 else tail!!.left!!.`val`
        }

        fun isEmpty(): Boolean {
            return len == 0
        }

        fun isFull(): Boolean {
            return len == k
        }
    }
}