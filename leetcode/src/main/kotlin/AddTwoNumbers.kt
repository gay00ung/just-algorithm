package org.example

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var head1 = l1
        var head2 = l2

        val dummy = ListNode(0)
        var current = dummy

        var carry = 0

        while (head1 != null || head2 != null || carry != 0) {
            val value1 = head1?.`val` ?: 0
            val value2 = head2?.`val` ?: 0

            val sum = value1 + value2 + carry

            carry = sum / 10 // 자릿수는 뒤로 넘겨주는 방식 활용
            val digit = sum % 10

            current.next = ListNode(digit)
            current = current.next!!

            head1 = head1?.next
            head2 = head2?.next
        }
        return dummy.next
    }
}
