package Easy;

import java.util.Scanner;

/**
 * 13. Roman to Integer
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
 * Given a roman numeral, convert it to an integer. 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
	public static void main(String[] args) {
		System.out.println("Please input a Roman number:");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("The integer of this Roman number is:\n"+romanToInt(str));

	}

	public static int romanToInt(String s) {
		int result = 0;
		boolean cMark = false;
		boolean xMark = false;
		boolean iMark = false;
		int addNum = 0;
		
		for (char ch : s.toCharArray()) {
			switch (ch) {
			case 'M':
				if (cMark) {
					addNum = 800;
				} else {
					addNum = 1000;
				}
				break;
			case 'D':
				if (cMark) {
					addNum = 300;
				} else {
					addNum = 500;
				}
				break;
			case 'C':
				cMark = true;
				if (xMark) {
					addNum = 80;
				} else {
					addNum = 100;
				}
				break;
			case 'L':
				if (xMark) {
					addNum = 30;
				} else {
					addNum = 50;
				}
				break;
			case 'X':
				xMark = true;
				if (iMark) {
					addNum = 8;
				} else {
					addNum = 10;
				}	
				break;
			case 'V':
				if (iMark) {
					addNum = 3;
				} else {
					addNum = 5;
				}
				break;
			case 'I':
				iMark = true;
				addNum = 1;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
			
			result += addNum;
		}
		
		return result;
	}
}
