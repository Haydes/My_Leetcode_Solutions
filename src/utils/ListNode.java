package utils;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {

	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	@Override
	public String toString() {
		ListNode current = this;
		String str = "";
		while (current != null) {
			str = str + current.val + "->";
			current = current.next;
		}
		return str;
	}
	
}
