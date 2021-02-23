package Easy;

import utils.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new sorted list. The new
 * list should be made by splicing together the nodes of the first two lists.
 *
 */
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		ListNode mergedList = MergeTwoList2(list1, list2);
		System.out.println(mergedList);
	}

	/**
	 * faster than 100%
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode newList = new ListNode();
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		ListNode current = newList;
		if (temp1 == null) {
			return l2;
		}
		if (temp2 == null) {
			return l1;
		}

		while (temp1 != null && temp2 != null) {
			if (temp1.val == temp2.val) {
				current.next = new ListNode(temp1.val, new ListNode(temp2.val));
				current = current.next.next;
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else if (temp1.val < temp2.val) {
				current.next = new ListNode(temp1.val);
				current = current.next;
				temp1 = temp1.next;
			} else {
				current.next = new ListNode(temp2.val);
				current = current.next;
				temp2 = temp2.next;
			}
		}

		if (temp1 == null) {
			while (temp2 != null) {
				current.next = new ListNode(temp2.val);
				current = current.next;
				temp2 = temp2.next;
			}
		} else {
			while (temp1 != null) {
				current.next = new ListNode(temp1.val);
				current = current.next;
				temp1 = temp1.next;
			}
		}
		return newList.next;
	}

	public static ListNode MergeTwoList2(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode newList = new ListNode();
		ListNode current = newList;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				current = current.next;
				l1 = l1.next;
			} else {
				current.next = l2;
				current = current.next;
				l2 = l2.next;
			}
		}
		if (l1 == null) {
			current.next = l2;
		} else {
			current.next = l1;
		}
		return newList.next;
	}
}
