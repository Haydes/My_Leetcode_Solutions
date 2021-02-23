package Medium;

import utils.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * 
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 *
 */

public class RmNthNodeFromEndOfList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		ListNode current = removeNthFromEnd(head, 1);
		while (current != null) {
			System.out.println(current.val);
			current = current.next;
		}
	}

	/**
	 * faster than 100%
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		// use fastNode to traverse the list
		ListNode fastNode = head;
		// use slowNode to find the node for removing
		ListNode slowNode = head;
		if (head == null) {
			return null;
		}
		// fastNode should be n node faster than the slowNode
		for (int i = 0; i < n; i++) {
			if (fastNode != null) {
				fastNode = fastNode.next;
			} else { // there is no n nodes
				return head;
			}
		}
		// use a node to record the node before slowNode
		ListNode preNode = new ListNode();
		// initially set preNode's next node to be null
		preNode.next = null;
		// traverse the list till the fastNode is at the end of the list
		while (fastNode != null) {
			// keep recording the previous slowNode
			preNode = slowNode;
			// keep going next
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}
		// preNode's next is null, slowNode is steal the head node
		// so the head node needs to be removed
		if (preNode.next == null) {
			head = head.next;
		} else {
			// preNode is the previous node of slowNode, remove the slowNode
			preNode.next = slowNode.next;
		}

		return head;
	}
}