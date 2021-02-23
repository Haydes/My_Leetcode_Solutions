package Medium;

import java.util.Scanner;

/**
 * 12. Integer to Roman
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 *
 *
 	Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
	
 * For example, two is written as II in Roman numeral, just two one's added
 * together. Twelve is written as, XII, which is simply X + II. The number
 * twenty seven is written as XXVII, which is XX + V + II.
 *
 */
public class IntegerToRoman {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please input an integer:");
		int num = sc.nextInt();
		sc.close();
		System.out.println(intToRoman(num));
		System.out.println(intToRoman2(num));

	}

	public static String intToRoman(int num) {
		String str = "";
		int thousand = num / 1000;
		int hundred = num / 100 % 10;
		int ten = num / 10 % 10;
		int digit = num % 10;
		for (int i = 0; i < thousand; i++) {
			str += "M";
		}
		if (hundred > 0) {
			if (hundred == 9) {
				str += "CM";
			} else if (hundred >= 5 && hundred < 9) {
				str += "D";
				for (int i = 0; i < hundred - 5; i++) {
					str += "C";
				}
			} else if (hundred == 4) {
				str += "CD";
			} else {
				for (int i = 0; i < hundred; i++) {
					str += "C";
				}
			}
		}

		if (ten > 0) {
			if (ten == 9) {
				str += "XC";
			} else if (ten >= 5 && ten < 9) {
				str += "L";
				for (int i = 0; i < ten - 5; i++) {
					str += "X";
				}
			} else if (ten == 4) {
				str += "XL";
			} else {
				for (int i = 0; i < ten; i++) {
					str += "X";
				}
			}
		} 
		
		if (digit > 0) {
			if (digit == 9) {
				str += "IX";
			} else if (digit >= 5 && digit < 9) {
				str += "V";
				for (int i = 0; i < digit-5; i++) {
					str += "I";
				}
			} else if (digit == 4) {
				str += "IV";
			} else {
				for (int i = 0; i < digit; i++) {
					str += "I";
				}
			}
		}

		return str;
	}
	
	public static String intToRoman2(int n) {
		int arr[] = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		String str[] = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
		StringBuilder sb = new StringBuilder();
		int i=12;
		while(n>0) {
			int div = n/arr[i];
			n = n%arr[i];
			while(div-->0) {
				sb.append(str[i]);
			}
			i--;
		}
		return sb.toString();
        
    }
}
