package string.Reverse_Words_in_a_String;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reverseWords("Hello World! A");
        System.out.println(solution.reverseWords_A2(" Hello  World! A"));

    }

    /**
     * the string may be separated by space more than one,
     * so the 'split' method's parameter is '\\s+'
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length-1; i >= 0; i--) {
            stringBuilder.append(arr[i]);
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }


    public String reverseWords_A1(String s) {
        String[] split = s.split(" ");
        String out = "";
        //System.out.println(split.length);
        for(int i = split.length - 1; i >= 0; i--){
            //System.out.println(split[i].length());
            if(!split[i].isEmpty()){
                out += split[i] + " ";
            }
        }
        return out.trim();
    }

    public String reverseWords_A2(String s) {
        int end = s.length()-1;
        StringBuilder sb = new StringBuilder();
        while( end >= 0 ){
            if(s.charAt(end) == ' '){
                end--;
                continue;
            }
            int start = s.lastIndexOf(' ',end);
            sb.append(s.substring(start+1, end+1)).append(' ');
            end = start-1;
        }
        return sb.length()==0?"":sb.substring(0,sb.length()-1);
    }


    /**
     * A answer use stack.
     * @param s
     * @return
     */
    public String reverseWords_A3(String s) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;

            sb.append(c);
            if (i + 1 >= s.length() || s.charAt(i + 1) == ' ') {
                stack.push(sb.toString());
                sb.setLength(0);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (stack.size() >= 1) sb.append(" ");
        }

        return sb.toString();
    }

}
