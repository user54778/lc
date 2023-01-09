package linked_lists;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null); // returns head of reversed list, prev pointer must be null to start
    }

    private ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }

        ListNode next = head.next;  // next pointer
        head.next = prev;           // store our next pointer to the previous value
        return reverseList(next, head); // recursively traverse to next node
    }
}
