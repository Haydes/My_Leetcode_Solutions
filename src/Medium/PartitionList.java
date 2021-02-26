package Medium;

import utils.ListNode;

/**
 * 86. Partition List
 * 
 * Given the head of a linked list and a value x, partition it such that all
 * nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 *
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 200].
 * 
 * -100 <= Node.val <=100
 * 
 * -200 <= x <= 200
 */
public class PartitionList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1,
				new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
		System.out.println(head);
		ListNode partition = partition2(head, 3);
		System.out.println(partition);
	}

	/**
	 * 链表内调换位置
	 * 
	 * 0 ms, faster than 100.00%
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
	public static ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode();
		dummy.next = head;

		ListNode pre = dummy;
		ListNode current = dummy.next;
		// 插入的位置在insertPos的下一个
		ListNode insertPos = dummy;

		while (current != null) {
			// 如果当前值比x小，则移动到当前需要插入的位置
			if (current.val < x) {
				// 前一个的下一个为当前的下一个
				pre.next = current.next;
				// 当前的下一个为insertPos的下一个
				current.next = insertPos.next;
				// 然后要插入的下一个位置变为current
				insertPos.next = current;
				insertPos = current;

			}
			pre = current;
			current = current.next;

		}

		return dummy.next;
	}

	/**
	 * 小的全部放第一个链表，大的全部放第二个，然后第一个第二个链表连起来
	 * 
	 * 0 ms, faster than 100.00%
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
	public static ListNode partition2(ListNode head, int x) {
		ListNode node1 = new ListNode();
		ListNode node2 = new ListNode();
		ListNode n1 = node1;
		ListNode n2 = node2;
		ListNode current = head;
		while (current != null) {
			if (current.val < x) {
				n1.next = current;
				n1 = n1.next;
			} else {
				n2.next = current;
				n2 = n2.next;
			}
			current = current.next;
		}
		n2.next = null;
		n1.next = node2.next;
		return node1.next;
	}
}
