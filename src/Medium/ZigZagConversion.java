package Medium;

import java.util.Iterator;
import java.util.Scanner;

/***
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 */
public class ZigZagConversion {
	public static void main(String[] args) {
		String s;
		int numRows;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your string:");
		s = sc.nextLine();
		System.out.println("Please input a numRows number:");
		numRows = sc.nextInt();
		String convertedStr = convert(s, numRows);
		System.out.println(convertedStr);
	}
	
	public static String convert(String s, int numRows) {
		String[] strings = new String[numRows];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = "";
		}
		String convertedStr = "";
		boolean isUp = true; 
		
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			strings[j] += s.charAt(i);
			if (j == 0 || j == numRows-1) {
				isUp = !isUp;
			}
			if (strings.length != 1) {
				if (isUp) {
					j--;
				} else {
					j++;
				}
			}
		}

		for (String string : strings) {
			convertedStr += string;
		}
        return convertedStr;
    }
}
