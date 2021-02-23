package Medium;

import utils.ListNode;

/**
 * 61. Rotate List
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 500].
 * 
 * -100 <= Node.val <=100
 * 
 * 0 <= k <= 2 * 109
 *
 */
public class RoatateList {
	public static void main(String[] args) {
		ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		System.out.println(rotateRight(node, 5));
	}

	/**
	 * faster than 100.0%
	 * @param head
	 * @param k
	 * @return
	 */
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}
        ListNode current = head;
		int size = 0;
		while (current != null) {
			size++;
			current = current.next;
		}
		k = k % size;
		// 双指针, 相差为k
		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		// fast是最后一个node, slow所在的node就是新头部的前一个node
        fast.next = head;
        head = slow.next;
		slow.next = null;
		
		return head;
	}
}
