package linkedList

import java.util.*

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 */

class PalindromeLinkedList {
    // 1. Deque를 사용하여 정방향 추출값, 역방향 추출값이 동일한지 확인해 본다.
    fun isPalindrome1(head: ListNode?): Boolean {
        val deque: Deque<Int> = LinkedList()
        var node = head
        while(node != null) {
            deque.add(node.`val`)
            node = node.next
        }

        while(!deque.isEmpty() && deque.size > 1) {
            if(deque.pollFirst() != deque.pollLast()) {
                return false
            }
        }
        return true
    }

    // 2. Runner를 활용해서 속도가 2배 차이가 나는 러너들을 통해 역방향 연결 리스트를 추출하여 비교해본다.
    fun isPalindrome(head: ListNode?): Boolean {
        var fast = head
        var slow = head

        while (fast != null && fast.next != null) { // 빠른 러너의 next가 존재하지 않을 때까지 이동
            fast = fast.next?.next
            slow = slow?.next
        }

        if (fast != null) { // 홀수일 경우를 대비하여 느린 러너를 한 칸 앞으로 이동시켜, 중앙값을 비켜가도록 한다.
            slow = slow?.next
        }

        var rev: ListNode? = null // 느린 러너를 기준으로 역순 리스트를 생성한다.
        while (slow != null) {
            val next = slow.next
            slow.next = rev
            rev = slow
            slow = next
        }

        var revHead = rev // 생성된 역순 리스트와 정방향 리스트를 비교하여 팰린드론 여부를 확인한다.
        var currentHead = head
        while (revHead != null) {
            if (revHead.`val` != currentHead?.`val`) {
                return false
            }
            revHead = revHead.next
            currentHead = currentHead?.next
        }

        return true
    }
}