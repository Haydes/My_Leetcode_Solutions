package Medium;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * 144. Binary Tree Preorder Traversal
 * 
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 *
 */
public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		System.out.println(preorderTraversal(root));
	}

	/**
	 * faster than 100.00%
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traversePreorder(root, result);
		return result;
	}

	public static void traversePreorder(TreeNode node, List<Integer> list) {
		if (node != null) {
			list.add(node.val);
			traversePreorder(node.left, list);
			traversePreorder(node.right, list);
		}
	}
}
