package StackAndQueue.BackspaceStringCompare;

import java.util.Stack;

public class Solution {

    public boolean backspaceCompare(String S, String T) {
        char[] c1 = S.toCharArray();
        char[] c2 = T.toCharArray();

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (char c : c1) {
            if (c == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.push(c);
            }
        }

        for (char c : c2) {
            if (c == '#') {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
            } else {
                s2.push(c);
            }
        }

        if (s1.size() != s2.size()) {
            return false;
        }

        while (!s1.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        return true;
    }

}
