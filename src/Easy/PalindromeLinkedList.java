package Easy;

import utils.ListNode;

/**
 * 234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.
 *
 */
public class PalindromeLinkedList {
	public static void main(String[] args) {
		ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
		boolean palindrome = isPalindrome(node);
		System.out.println(node);
		System.out.println(palindrome);
	}
	
	/**
	 * 快慢指针，后半段反转判断, faster than 95.60%
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		boolean result = true;
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		// 这时候slow.next是后半段起点, 反转后半段
		ListNode pre = null;
		while (slow != null) {
			// 把当前点的下一个保存
			ListNode temp = slow.next;
			slow.next = pre;
			pre = slow;
			slow = temp;
		}
		
		// 对比前后半段
		ListNode back = pre;
		ListNode front = head;
		while (back != null && front != null) {
			if (back.val != front.val) {
				result = false;
				break;
			}
			back = back.next;
			front = front.next;
		}
		
		// 还原链表
		ListNode current = null;
		while (pre != null) {
			ListNode temp = pre.next;
			pre.next = current;
			current = pre;
			pre = temp;
		}
		
        return result;
    }
}
