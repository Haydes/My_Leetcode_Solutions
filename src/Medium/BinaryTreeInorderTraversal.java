package Medium;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * 94. Binary Tree Inorder Traversal
 * 
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 *
 */
public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(inorderTraversal(root));
	}

	/**
	 * faster than 100.00%
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traverseInOrder(root, result);
		return result;
	}

	public static void traverseInOrder(TreeNode node, List<Integer> list) {
		if (node != null) {
			traverseInOrder(node.left, list);
			list.add(node.val);
			traverseInOrder(node.right, list);
		}
	}
}
