package Medium;

import utils.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * 
 * Given the head of a sorted linked list, delete all nodes that have duplicate
 * numbers, leaving only distinct numbers from the original list. Return the
 * linked list sorted as well.
 *
 */
public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		ListNode node = new ListNode(1,
				new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
		System.out.println(deleteDuplicates(node));
	}

	/**
	 * 0 ms, faster than 100.00%
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		// 空链表和结点只有一个的链表不会重复
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode();
		dummy.next = head;
		// 第一个对比结点的前一个
		ListNode pre = dummy;
		// 第一个对比结点
		ListNode current = pre.next;
		ListNode nextNode = current.next;
		boolean duplicated = false;
		while (current != null && nextNode != null) {
			if (current.val == nextNode.val) {
				nextNode = nextNode.next;
				duplicated = true;
			} else {
				if (duplicated) {
					pre.next = nextNode;
					current = nextNode;
					if (current != null) {
						nextNode = current.next;
					}
				} else {
					pre = current;
					current = nextNode;
					nextNode = current.next;
				}
				duplicated = false;

			}
		}

		// 这里防止最后连续相同字符导致nextNode为null没有跳进删除语句的情况
		if (duplicated) {
			pre.next = nextNode;
		}

		return dummy.next;
	}

}
