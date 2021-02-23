package Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. Text Justification
 * 
 * Given an array of words and a width maxWidth, format the text such that each
 * line has exactly maxWidth characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * Note: A word is defined as a character sequence consisting of non-space
 * characters only. Each word's length is guaranteed to be greater than 0 and
 * not exceed maxWidth. The input array words contains at least one word.
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 300
 * 
 * 1 <= words[i].length <= 20
 * 
 * words[i] consists of only English letters and symbols.
 * 
 * 1 <= maxWidth <= 100
 * 
 * words[i].length <= maxWidth
 */
public class TextJustification {
	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "aaaaaa", "a", "aaa", "justification." };
		int maxWidth = 16;
		System.out.println(fullJustify(words, maxWidth));
		System.out.println(fullJustify2(words, maxWidth));
	}

	/**
	 * 1. 先找到能到达的最右边的单词
	 * 
	 * 2. 如果只有一个单词，直接补空格;如果有多个单词，计算补空格;如果是最后一行，单词间只有一个空格，最后补空格
	 * 
	 * 6 ms, faster than 9.44%
	 * 
	 * @param words
	 * @param maxWidth
	 * @return
	 */
	public static List<String> fullJustify(String[] words, int maxWidth) {
		int left = 0;
		int maxRight = 0;
		String currentLine;
		List<String> result = new ArrayList<String>();
		while (left < words.length) {
			maxRight = findMaxRight(words, left, maxWidth);
			// 有最左边的索引和最右边的索引, 判断当前行
			currentLine = justifyOneLine(left, maxRight, words, maxWidth);
			result.add(currentLine);
			left = maxRight + 1;
		}
		return result;
	}

	/**
	 * 返回当前行的字符串
	 * 
	 * (如果只有一个单词，直接补空格;如果有多个单词，计算补空格;如果是最后一行，单词间只有一个空格，最后补空格)
	 * 
	 * @param left
	 * @param right
	 * @param words
	 * @param maxWidth
	 * @return
	 */
	public static String justifyOneLine(int left, int right, String[] words, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		// 只有一个单词
		if (left == right) {
			sb.append(words[left]).append(fillBlank(maxWidth - words[left].length()));
			return sb.toString();
		}
		// 如果是最后一行
		if (right == words.length - 1) {
			sb.append(words[left]);
			int totalLen = words[left].length();
			for (int i = left + 1; i <= right; i++) {
				sb.append(" ").append(words[i]);
				totalLen += (1 + words[i].length());
			}
			// 末尾添加maxWidth-totalLen个空格
			sb.append(fillBlank(maxWidth - totalLen));
			return sb.toString();
		}

		// 如果有多个单词
		// 当前行剩下总空间
		int remainSpace = maxWidth - wordLengthOfCurrentLine(left, right, words);
		// 当前要添加的空格数
		int currentSpace = remainSpace / (right - left);
		// 还需要添加空格的空间数
		int extra = remainSpace % (right - left);
		sb.append(words[left]);
		for (int i = left + 1; i <= right; i++) {
			// 添加currentSpace个空格,如果当前有extra,空格加一个,然后再添加单词
			String currentExtra = extra > 0 ? " " : "";
			extra--;
			sb.append(fillBlank(currentSpace)).append(currentExtra).append(words[i]);
		}
		return sb.toString();
	}

	/**
	 * 当前行单词内容占用长度
	 * 
	 * @param left
	 * @param right
	 * @param words
	 * @return
	 */
	public static int wordLengthOfCurrentLine(int left, int right, String[] words) {
		int sum = 0;
		for (int i = left; i <= right; i++) {
			sum += words[i].length();
		}
		return sum;
	}

	/**
	 * 空格填充
	 * 
	 * @param length
	 * @return
	 */
	public static String fillBlank(int length) {
		return String.valueOf(new char[length]).replace('\0', ' ');
	}

	/**
	 * 找到能放下的最多的单词数
	 * 
	 * @param words
	 * @param left
	 * @param maxWidth
	 * @return
	 */
	public static int findMaxRight(String[] words, int left, int maxWidth) {
		int maxRight = left;
		int sum = words[maxRight++].length();
		while (maxRight < words.length && sum + (words[maxRight].length() + 1) <= maxWidth) {
			sum += words[maxRight].length() + 1;
			maxRight++;
		}
		return maxRight - 1;
	}

	
	/**
	 * faster than 100%
	 * @param words
	 * @param L
	 * @return
	 */
	public static List<String> fullJustify2(String[] words, int L) {
		List<String> lines = new ArrayList<String>();
        
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                    	// count那里已经包含了一个空格被减掉,所以要把空格加回来,所以从0开始，能加多一个
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        
        
        return lines;
	}
}
