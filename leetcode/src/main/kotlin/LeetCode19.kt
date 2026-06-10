/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class LeetCode19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var length = 0
        var current = head

        while (current != null) {
            length++
            current = current.next
        }

        val removeIndex = length - n

        if (removeIndex == 0) {
            return head?.next
        }

        current = head
        for (i in 0 until removeIndex - 1) {
            current = current?.next
        }

        current?.next = current.next?.next
        return head
    }
}
