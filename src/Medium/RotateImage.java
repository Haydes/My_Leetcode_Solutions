package Medium;

/**
 * 48. Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image, rotate the image by
 * 90 degrees (clockwise).
 * 
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 *
 */
public class RotateImage {
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		for (int[] is : matrix) {
			for (int value : is) {
				System.out.print(value+" ");
			}
			System.out.println();
		}
		rotate2(matrix);
		System.out.println("--------------------");
		for (int[] is : matrix) {
			for (int value : is) {
				System.out.print(value+" ");
			}
			System.out.println();
		}
	}

	/**
	 * 先转置，再逆序, faster than 100%
	 * @param matrix
	 */
	public static void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i+1; j < matrix[0].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[i].length-1-j];
				matrix[i][matrix[i].length-1-j] = temp;
			}
		}
	}
	
	/**
	 * 先逆序，再交换, faster than 100%
	 * @param matrix
	 */
	public static void rotate2(int[][] matrix) {
		for (int i = 0; i < matrix.length/2; i++) {
			int[] temp = matrix[i];
			matrix[i] = matrix[matrix.length-1-i];
			matrix[matrix.length-1-i] = temp;
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}
