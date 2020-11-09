package dp.lintcode.p03_longest_valid_parentheses;

import java.util.Stack;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/5 11:46 下午
 */
public class Solution {

    public static void main(String[] args) {
        String s = ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())";
        Solution solution = new Solution();
        solution.longestValidParentheses(s);

    }

    /**
     * 像下面的例子，中间隔开的只能选其中最大的。
     * "((() (()) ())) ()() ) ()() ("
     * "((((()) ()) ()() ) ()() ("
     * 下面返回的结果是错误的，但是我不知道我的代码出了什么问题？
     * ")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())"
     * "((()))())"
     *
     * @param s
     * @return
     */
    public int longestValidParentheses_W1(String s) {
        // write your code here
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        int curMax = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == ')' && !stack.isEmpty()) {
                cnt = cnt + 2;
                stack.pop();
            } else if (c == '(') {
                stack.push(c);
            } else {
                curMax = Math.max(cnt, curMax);
                cnt = 0;
                stack.clear();
            }
        }
        return cnt;
    }


    /**
     * 具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}
