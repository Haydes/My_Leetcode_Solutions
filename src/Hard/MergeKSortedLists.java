package Hard;

import utils.ListNode;

/**
 * 23. Merge k Sorted Lists
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 */
public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode l3 = new ListNode(2, new ListNode(6));
		ListNode[] lists = new ListNode[3];
		lists[0] = l1;
		lists[1] = l2;
		lists[2] = l3;

		ListNode mergeKLists = mergeKLists2(lists);
		System.out.println(mergeKLists);

	}

	/**
	 * faster than 17.30% - merge one by one
	 * 
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		ListNode mergedList = lists[0];
		for (int i = 1; i < lists.length; i++) {
			mergedList = merge2Lists(mergedList, lists[i]);
		}
		return mergedList;
	}

	public static ListNode merge2Lists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode newList = new ListNode();
		ListNode current = newList;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				current = current.next;
				l1 = l1.next;
			} else {
				current.next = l2;
				current = current.next;
				l2 = l2.next;
			}
		}

		if (l1 != null) {
			current.next = l1;
		} else {
			current.next = l2;
		}
		return newList.next;
	}

	/**
	 * faster than 100% - Divide and conquer
	 * 
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists2(ListNode[] lists) {
		if (lists.length == 0) {
			return null;
		}

		int len = lists.length;

		while (len > 1) {
			int count = 0;
			for (int i = 0; i < len; i += 2) {
				if (i + 1 >= len) {
					// for example: 3 lists(index: 0 1 2). 0 is merged with 1, 2 is remained.
					lists[count] = lists[i];
					count++;
				} else {
					lists[count] = merge2Lists(lists[i], lists[i + 1]);
					count++;
				}
			}
			// the number of elements we need to consider
			len = count;
		}
		return lists[0];
	}
}
