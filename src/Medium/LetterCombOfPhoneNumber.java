package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, 
 * return all possible letter combinations that the number could represent.
  
 * A mapping of digit to letters (just like on the telephone buttons) is given below. 
 * Note that 1 does not map to any letters.
 *
 */
public class LetterCombOfPhoneNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String digits = sc.nextLine();
		List<String> combinations = letterCombinations(digits);
		System.out.println(combinations);
		
		List<String> combinations2 = letterCombinations2(digits);
		System.out.println(combinations2);
	}

	public static List<String> letterCombinations(String digits) {
		List<String> combination = new ArrayList<String>();
		int len = digits.length();
		if (len == 0) {
			return combination;
		}
		int phoneNum = Integer.parseInt(digits);
		
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = phoneNum%10;
			phoneNum /= 10;
		}
		
		
		for (int i = len - 1; i >= 0; i--) {
			int digit = arr[i];
			combination = combine(combination, digit);
		}
		
		return combination;
	}
	
	/**
	 * 
	 * @param list
	 * @param digit (has to be 2-9)
	 * @return
	 */
	public static List<String> combine(List<String> list, int digit){
		List<String> resultList = new ArrayList<String>();
		StringBuilder letters;
		switch (digit) {
		case 2: {
			letters = new StringBuilder("abc");
			break;
		}
		case 3: {
			letters = new StringBuilder("def");
			break;
		}
		case 4: {
			letters = new StringBuilder("ghi");
			break;
		}
		case 5: {
			letters = new StringBuilder("jkl");
			break;
		}
		case 6: {
			letters = new StringBuilder("mno");
			break;
		}
		case 7: {
			letters = new StringBuilder("pqrs");
			break;
		}
		case 8: {
			letters = new StringBuilder("tuv");
			break;
		}
		case 9: {
			letters = new StringBuilder("wxyz");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + digit);
		}
		
//		for (int i = 0; i < letters.length(); i++) {
//			if (list.size() == 0) {
//				resultList.add(letters.charAt(i)+"");
//			} else {
//				for (String str : list) {
//					str += letters.charAt(i);
//					resultList.add(str);
//				}
//			}
//		}
		
		if (list.isEmpty()) {
			for (int i = 0; i < letters.length(); i++) {
				resultList.add(letters.charAt(i)+"");
			}
		} else {
			for (String str : list) {
				for (int i = 0; i < letters.length(); i++) {
					String string = str + letters.charAt(i);
					resultList.add(string);
				}
			}
		}
		return resultList;
	}





	/**
	 * 更快的BFS方法
	 */
	
	private static List<String> list = new ArrayList<String>();
	private static LinkedList<String> queue = new LinkedList<String>();

	public static List<String> letterCombinations2(String digits) {
	    list.clear();
	    queue.clear();
	    
	    if(digits == null || digits.length() == 0)
	        return list;
	    
	    String[] sa = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"};
	    
	    queue.add("");
	    int k = 0;

	    StringBuilder sb = new StringBuilder();
	    while(!queue.isEmpty()){
	        if(k == digits.length()){
	            list.add(queue.poll());             
	        }
	        else{
	            int size = queue.size();
	            int n = Character.getNumericValue(digits.charAt(k++));            
	            for(int i=0;i<size;i++){
	                String tempS = queue.poll();
	                for(int j=0;j<sa[n].length();j++){
	                    queue.add(sb.append(tempS).append(sa[n].charAt(j)).toString());      
	                    sb.setLength(0);
	                }
	            }
	        }
	    }
	                               
	    return list;
	}

}



