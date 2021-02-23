package Hard;

import utils.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 *
 */
public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
		ListNode reverseKGroup = reverseKGroup(listNode, 3);
		System.out.println(reverseKGroup);
	}

	/**
	 * faster than 100%
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode reversed = new ListNode();
		ListNode current = reversed;
		current.next = head;
		while (current != null) {
			//reverse next k nodes
			current.next = reverseKNodes(current.next, k);
			// current go to next k position
			int count = 0;
			while (current != null && count < k) {
				current = current.next;
				count++;
			}
		}
		return reversed.next;
	}

	/**
	 * handle k nodes
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode reverseKNodes(ListNode head, int k) {
		if (!hasEnoughNodes(head, k)) {
			return head;
		}
		ListNode prev = null;
		ListNode tail = head;
		ListNode temp;

		while (k > 0) {
			//record next node
			temp = head.next;
			//change next node to the previous node
			head.next = prev;
			//change previous node to current node
			prev = head;
			//change current node to the recorded next node
			head = temp;
			k--;
		}
		tail.next = head;
		return prev;
	}

	/**
	 * Check whether the list has enough nodes to reverse
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public static boolean hasEnoughNodes(ListNode head, int k) {
		int count = 0;
		ListNode current = head;
		while (count < k && current != null) {
			count++;
			current = current.next;
		}
		if (count == k) {
			return true;
		}
		return false;
	}
}
