package Medium;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

/**
 * 95. Unique Binary Search Trees II
 * 
 * Given an integer n, return all the structurally unique BST's (binary search
 * trees), which has exactly n nodes of unique values from 1 to n. Return the
 * answer in any order.
 *
 */
public class UniqueBinarySearchTreesII {
	public static void main(String[] args) {
		List<TreeNode> trees = generateTrees(3);
		System.out.println(trees);
	}

	/**
	 * 1 ms, faster than 93.81%
	 * 
	 * @param n
	 * @return
	 */
	public static List<TreeNode> generateTrees(int n) {
		return generate(1, n);
	}

	/**
	 * 递归，生成左半边子树和右半边子树
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<TreeNode> generate(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
			return list;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftSubTrees = generate(start, i - 1);
			List<TreeNode> rightSubTrees = generate(i + 1, end);
			for (TreeNode left : leftSubTrees) {
				for (TreeNode right : rightSubTrees) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		return list;
	}
}
