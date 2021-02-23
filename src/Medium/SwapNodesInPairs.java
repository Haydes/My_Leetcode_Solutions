package Medium;

import utils.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 *
 */
public class SwapNodesInPairs {
	public static void main(String[] args) {
		ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))));
		ListNode swapNode = swapPairs(listNode);
		System.out.println(swapNode);
	}

	/**
	 * 
	 * faster than 100%
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode swapPairs(ListNode head) {
		ListNode swapped = new ListNode();
		ListNode current = swapped;
		current.next = head;

		while (current != null && current.next != null && current.next.next != null) {
			// current.next = swap2Nodes(current.next);
			// equals to the above comment line
			// start
			ListNode first = current.next;
			ListNode second = current.next.next;
			first.next = second.next;
			second.next = first;
			current.next = second;
			// end

			current = current.next.next;
		}
		return swapped.next;
	}

	/**
	 * swap 2 nodes
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode swap2Nodes(ListNode head) {
		// already check that head is not equal to null
		if (head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode second = head.next;
		first.next = second.next;
		second.next = first;
		head = second;
		return head;
	}
}
