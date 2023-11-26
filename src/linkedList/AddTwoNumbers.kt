package linkedList

import kotlin.math.ln1p

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1var = l1
        var l2var = l2

        var node = ListNode(0)
        var root = node

        var sum: Int // 자릿수의 합
        var carry = 0 // 자리올림수
        var remainder: Int // 나머지

        while(l1var != null || l2var != null || carry != 0) {
            sum = 0

            if(l1var != null) { // 첫 번째 연결리스트 합산 및 진행
                sum += l1var.`val`
                l1var = l1var.next
            }
            if(l2var != null) { // 두 번째 연결리스트 합산 및 진행
                sum += l2var.`val`
                l2var = l2var.next
            }

            remainder = (sum + carry) % 10 // 10으로 나누었을 때 나머지는 현재 자릿수의 값으로 등록
            carry = (sum + carry) / 10 // 10으로 나누었을 때 몫은 자릿수가 증가했다는 의미 -> 자리올림수로 사용
            node.next = ListNode(remainder) // 덧셈의 결과를 리스트에 등록
            node = node.next!! // 다음으로 이동
        }

        return root.next
    }
}