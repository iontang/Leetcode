package problems_by_year.year_2020.month_04.problems_20200427.Backspace_String_Compare;


import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 */
public class Solution {

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        Solution solution = new Solution();
        solution.backspaceCompare_A1(S, T);

    }

    public boolean backspaceCompare_W1(String S, String T) {
        // #a#c
        // ab##
        int sLen = S.length();
        int sIndex = sLen - 1;
        StringBuilder sSubStr = new StringBuilder();
        while (sIndex > 0) {
            if (S.charAt(sIndex) == '#' && S.charAt(sIndex-1) != '#') {
                sIndex = sIndex - 2;
            } else if (S.charAt(sIndex) == '#' && S.charAt(sIndex-1) == '#') {
                --sIndex;
            } else {
                sSubStr.append(S.charAt(sIndex));
                --sIndex;
            }
        }
        int tLen = T.length();
        int tIndex = tLen - 1;
        StringBuilder tSubStr = new StringBuilder();
        return true;
    }

    public boolean backspaceCompare_A1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        // ab##
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || skipS > 0) ) {
                if (S.charAt(i) == '#') {
                    ++skipS;
                } else {
                    --skipS;
                }
                --i;
            }
            while (j >= 0 && (T.charAt(j) == '#' || skipT > 0)) {
                if (T.charAt(j) == '#') {
                    ++skipT;
                } else {
                    --skipT;
                }
                --j;
            }
            if (i < 0 || j < 0) return i == j;
            if (S.charAt(i--) != T.charAt(j--)) {
                return false;
            }
        }
        return i == j;
    }

    public boolean backspaceCompare_A2(String s, String t) {
        int i=s.length()-1,j=t.length()-1;
        while(true){
            int back=0;
            while(i>=0 && (back>0 || s.charAt(i)=='#')){
                back+=s.charAt(i)=='#'?1:-1;
                i--;
            }
            back=0;
            while(j>=0 && (back>0 || t.charAt(j)=='#')){
                back+=t.charAt(j)=='#'?1:-1;
                j--;
            }
            if(i>=0 && j>=0 && s.charAt(i)==t.charAt(j)){
                i--;
                j--;
            } else break;
        }
        return i==-1 && j==-1;
    }


    public boolean backspaceCompare(String S, String T) {
        // the length of S and T may not equal.
        int len = S.length();
        Stack<Character> sStack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) != '#') {
                sStack.push(S.charAt(i));
            } else if (!sStack.isEmpty()) {
                sStack.pop();
            }
        }

        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                tStack.push(T.charAt(i));
            } else if (!tStack.isEmpty()) {
                tStack.pop();
            }
        }
        if (sStack.size() != tStack.size()) return false;
        while (!sStack.isEmpty()) {
            Character sc = sStack.pop();
            Character tc = tStack.pop();
            if (sc != tc) return false;
        }
        return true;
    }


}
