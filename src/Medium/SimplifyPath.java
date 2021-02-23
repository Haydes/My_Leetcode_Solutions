package Medium;

import java.util.Stack;

/**
 * 71. Simplify Path
 * 
 * Given a string path, which is an absolute path (starting with a slash '/') to
 * a file or directory in a Unix-style file system, convert it to the simplified
 * canonical path.
 * 
 * In a Unix-style file system, a period '.' refers to the current directory, a
 * double period '..' refers to the directory up a level, and any multiple
 * consecutive slashes (i.e. '//') are treated as a single slash '/'. For this
 * problem, any other format of periods such as '...' are treated as
 * file/directory names.
 * 
 * The canonical path should have the following format:
 * 
 * The path starts with a single slash '/'. Any two directories are separated by
 * a single slash '/'. The path does not end with a trailing '/'. The path only
 * contains the directories on the path from the root directory to the target
 * file or directory (i.e., no period '.' or double period '..') Return the
 * simplified canonical path.
 *
 */
public class SimplifyPath {
	public static void main(String[] args) {
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/home//foo/"));
	}

	/**
	 * 8 ms, faster than 29.80%
	 * 
	 * @param path
	 * @return
	 */
	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		String[] dirNames = path.split("/");
		for (int i = 0; i < dirNames.length; i++) {
			if (dirNames[i].equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!dirNames[i].equals(".") && !dirNames[i].equals("") && !dirNames[i].equals("..")) {
				stack.push(dirNames[i]);
			}
		}

		String result = "";
		while (!stack.isEmpty()) {
			result = "/" + stack.pop() + result;
		}

		return result.isEmpty() ? "/" : result;
	}
}
