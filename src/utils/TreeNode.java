package utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "[" + getTreeNodeStr() + "]";
	}

	// BFS
	private String getTreeNodeStr() {
		String str = "";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(this);

		while (!queue.isEmpty()) {
			TreeNode poll = queue.poll();
			if (poll != null) {
				str += poll.val + ",";
				queue.add(poll.left);
				queue.add(poll.right);
			} else {
				str += "null,";
			}
		}
		return str;
	}
}
