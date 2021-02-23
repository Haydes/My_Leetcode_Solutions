package Medium;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * 145. Binary Tree Postorder Traversal
 * 
 * Given the root of a binary tree, return the postorder traversal of its nodes'
 * values.
 *
 */
public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(postorderTraversal(root));
	}

	/**
	 * faster than 100.00%
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traversePostorder(root, result);
		return result;
	}

	public static void traversePostorder(TreeNode node, List<Integer> list) {
		if (node != null) {
			traversePostorder(node.left, list);
			traversePostorder(node.right, list);
			list.add(node.val);
		}
	}
}
