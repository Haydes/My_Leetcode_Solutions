package Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.Node;

/**
 * 589. N-ary Tree Preorder Traversal
 * 
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 */
public class NAryTreePreorderTraversal {

	public static void main(String[] args) {
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		List<Node> list56 = new ArrayList<Node>();
		list56.add(node5);
		list56.add(node6);
		Node node3 = new Node(3, list56);
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		List<Node> list324 = new ArrayList<Node>();
		list324.add(node3);
		list324.add(node2);
		list324.add(node4);
		Node root = new Node(1, list324);

		System.out.println(preorder2(root));
	}

	static List<Integer> list = new ArrayList<Integer>();

	/**
	 * faster than 45.17%
	 * 
	 * 递归
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> preorder(Node root) {
		if (root == null) {
			return list;
		}

		list.add(root.val);
		if (root.children != null) {
			for (Node node : root.children) {
				preorder(node);
			}
		}
		return list;
	}

	/**
	 * faster than 45.17%
	 * 
	 * 迭代
	 * 
	 * @param root
	 * @return
	 */
	public static List<Integer> preorder2(Node root) {
		List<Integer> list2 = new ArrayList<Integer>();
		if (root == null) {
			return list2;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		Node node;
		while (!stack.isEmpty()) {
			node = stack.pop();
			list2.add(node.val);
			if (node.children != null) {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					stack.add(node.children.get(i));
				}
			}
		}
		return list2;
	}
}
