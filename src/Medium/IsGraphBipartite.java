package Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 785. Is Graph Bipartite?
 * 
 * Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Recall that a graph is bipartite if we can split its set of nodes into two
 * independent subsets A and B, such that every edge in the graph has one node
 * in A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j for
 * which the edge between nodes i and j exists. Each node is an integer between
 * 0 and graph.length - 1. There are no self edges or parallel edges: graph[i]
 * does not contain i, and it doesn't contain any element twice.
 *
 * Input: graph = [[1,3],[0,2],[1,3],[0,2]] 这个代表点0和1，3有边，点1和0，2右边。。。
 * 
 * Output: true
 * 
 * Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * 
 * 
 */
public class IsGraphBipartite {
	public static void main(String[] args) {
		int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
		boolean bipartite = isBipartite(graph);
		System.out.println(bipartite);
	}

	/**
	 * faster than 71.8%
	 * 
	 * @param graph
	 * @return
	 */
	public static boolean isBipartite(int[][] graph) {
		// 这个数组用来记录每个点在哪一个部分
		int[] biArray = new int[graph.length];
		// traverse every vertex
		for (int i = 0; i < graph.length; i++) {
			if (biArray[i] == 0) {
				biArray[i] = 1;
			} else {
				continue;
			}

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.offer(i);

			while (queue.size() > 0) {
				int v = queue.poll();
				// 遍历第v个点所有的临接点
				for (int vertex : graph[v]) {
					if (biArray[vertex] == 0) {
						biArray[vertex] = (biArray[v] == 1) ? 2 : 1;
						// 添加到队列
						queue.offer(vertex);
					} else if (biArray[vertex] == biArray[v]) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
