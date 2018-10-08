package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 规则：不多不少，必须要完全匹配单次，只需要删除，不需要调换位置
// s = "abpcplea", d = ["ale","apple","monkey","plea"]

//Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string.
//If there are more than one possible results, 
//return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

// 按照长度从大到小排序；
// 从大到小遍历符合条件的，返回符合条件的单次
public class FindLongestWord {
	
	public static void main(String[] args) {
		List<String> d = new ArrayList<String>();
//		d.add("ale");
//		d.add("apple");
//		d.add("monkey");
//		d.add("plea");
		d.add("a");
		d.add("b");
		d.add("c");
		String s = "abpcplea";
		
//		for (String s : d) 
//			System.out.println(s);
		
		FindLongestWord flw = new FindLongestWord();
		flw.findLongestWord(s, d);
		
	}

	/**
	 * 时间复杂度为O(kn), n = len(d), k is the length of string s 
	 * @param s
	 * @param d
	 * @return
	 */
    public String findLongestWord(String s, List<String> d) {
    	String curStr = "";
    	for (String e : d) {
    		curStr = CompareWord(e, s, curStr);
    	}
    	return curStr; // 注意，是返回空字符串，不是返回null
    }
    
    // 判断子串是否存在于父串中
    public static String CompareWord(String child, String word, String curStr) {
    	char[] childArr = child.toCharArray();
    	char[] wordArr = word.toCharArray();
    	int i = 0;
    	int j = 0;
    	while (i< child.length() && j < word.length()) {
			if (childArr[i] == wordArr[j]) {
				i++;
			}
			j++;
    	}
    	if (i == child.length()) {
			if (child.length() > curStr.length()) {
    			return child;
    		} else if (child.length() == curStr.length()) { // 相等的话，按照字典顺序返回，所以需要比较两个字符串的字典顺序【我这里直接使用了java的方法，如何自己实现？】
    			if (child.compareTo(curStr) < 0) {
    				return child;
    			} else {
    				return curStr;
    			}
    		}
    	}
    	return curStr;
    }
    
    /**
     * 参考答案1：
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord_A1(String s, List<String> d) {
        Collections.sort(d, (a,b) -> a.length() != b.length() ? -Integer.compare(a.length(), b.length()) :  a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray()) 
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            if (i == dictWord.length()) return dictWord;
        }
        return "";
    }
    
    
    public String findLongestWord_A2(String s, List<String> d) {
    	// String s = "abpcplea";
    	// d = ["ale","apple","monkey","plea"]
        String longest = "";
        for (String dictWord : d) {
            int i = 0;
            // compare s to each dictWord, 
            for (char c : s.toCharArray()) // 遍历s直到
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            // 结束的时候，i等于dictWord的长度，并且大于目前的最大长度单词
            if (i == dictWord.length() && dictWord.length() >= longest.length()) 
            	// 按照字典顺序返回
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
                    longest = dictWord;
        }
        return longest;
    }
    
    
    
    
    
}
