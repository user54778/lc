package linked_lists;

public class ReorderList {
    public void reorderList(ListNode head) {
        // find second portion of the list
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        assert slow != null;
        ListNode second = slow.next;    // second half of the list
        slow.next = null;               // split into two lists;
        ListNode prev = null;      // prev value; starts as null
        // reverse second half
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;  // first half
        second = prev;  // beginning of the second since prev is last node we looked at
        // merge two halves of the list
        while (second != null) {
            assert first != null;
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;    // val of second half
            second.next = temp1;    // insert second node between first and first.next

            // shift our pointers
            first = temp1;
            second = temp2;
        }
    }
}
