package Easy;

import utils.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * 
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 *
 */
public class RemoveDuplicatesfromSortedList {
	public static void main(String[] args) {
		ListNode node = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
		System.out.println(deleteDuplicates(node));
	}

	/**
	 * 0 ms, faster than 100.00%
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.next.val == current.val) {
				// current跟下一个重复，删除current.next
				current.next = current.next.next;
			} else {
				current = current.next;
			}

		}
		return head;
	}
}
