package Easy;

import utils.TreeNode;

public class SameTree {
	public static void main(String[] args) {
		TreeNode pNode = new TreeNode(1, new TreeNode(2), new TreeNode(1));
		TreeNode qNode = new TreeNode(1, new TreeNode(1), new TreeNode(2));
		System.out.println(isSameTree(pNode, qNode));
	}

	/**
	 * recursion, 0 ms, faster than 100.00%
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
