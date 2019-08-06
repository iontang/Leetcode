package divideandconquer;

import java.util.*;

/**
 *
 * 241：
 *
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
 * The valid operators are +, - and *.
 *
 * Example 1:
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * 思路：
 * 1、先组合出可能的计算公式
 *
 * 相关链接：
 * https://www.cnblogs.com/yrbbest/p/5006196.html
 * http://www.cnblogs.com/grandyang/p/4682458.html  ； 这个链接下面有相似的题目
 *
 * 32. Longest Valid Parentheses
 *
 * 301. Remove Invalid Parentheses
 *
 * 相似题目：
 * 95. Unique Binary Search Trees II
 * 224. Basic Calculator
 * 282. Expression Add Operators
 *
 *
 */
public class DifferentWaysToAddParentheses {

    static final List<Character> operators = new ArrayList<Character>(Arrays.asList('+', '-', '*'));
    // 或者下面的初始化方法：
//    private static Set<Character> operators = new HashSet<>();
//    static {
//        operators.add('+');
//        operators.add('-');
//        operators.add('*');
//    }

    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0)
            return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<Integer>();

        for(int i =0;i<input.length();i++) {
            char c = input.charAt(i);
            if (operators.contains(c)) { // 如果是操作符，
                List<Integer> l1 = diffWaysToCompute(input.substring(0,i));
                System.out.println("============== after l1 ================");
                List<Integer> l2 = diffWaysToCompute(input.substring(i+1));
                System.out.println("============== after l2 ================");
                // 每次， l1和l2只会存在一个元素
                for (int x : l1) {
                    for (int y : l2) {
                        if (c == '+') {
                            res.add(x+y);
                        } else if (c == '-') {
                            res.add(x -y);
                        } else {
                            res.add(x * y);
                        }
                     }
                }

            }
        }


        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }

        return res;
    }



    public static void main(String[] args) {
//        String s = "2-1-1";
        // 第一个分隔符号 "-"之后，得到的结果是 2: 2 - (1-1)
        // 第二个分隔符号 "-"之后，得到的结果是 0：（2-1）- 1
        // 要理解递归： 可以把 "s" 缩减为 "2-1"
        String s = "2-1";
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        System.out.println(differentWaysToAddParentheses.diffWaysToCompute(s));
    }




    public List<Integer> diffWaysToCompute_A1(String input) {
        char[] a = input.toCharArray();
        return helper(a,0,a.length-1,new HashMap<String,List<Integer>>());
    }

    private List<Integer> helper(char[] a,int l,int r,Map<String,List<Integer>> m){
        String key = String.valueOf(l)+'.'+String.valueOf(r);
        if(m.containsKey(key)) return m.get(key);
        int index = l;
        int num = 0;
        boolean pureNum = true;
        List<Integer> res = new ArrayList<>();
        while(true){
            while(index<=r && Character.isDigit(a[index])){
                if(pureNum) num = num*10 + (a[index]-'0');
                index++;
            }
            if(index <= r){
                pureNum = false;
                List<Integer> prev = helper(a,l,index-1,m);
                List<Integer> post = helper(a,index+1,r,m);
                for(int x:prev){
                    for(int y:post){
                        if(a[index] == '*') res.add(x*y);
                        else if(a[index] == '+') res.add(x+y);
                        else res.add(x-y);
                    }
                }
                index++;
            }
            else break;
        }
        if(pureNum){
            res.add(num);
        }
        m.put(key,res);
        return res;
    }



    Map<String, List<Integer>> map;
    public List<Integer> diffWaysToCompute_A2(String input) {
        map = new HashMap<>();
        return ways(input);
    }

    private List<Integer> ways(String input){
        if(map.containsKey(input)){
            return map.get(input);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char temp = input.charAt(i);
            if(temp == '+' || temp == '*' || temp == '-'){
                String left = input.substring(0, i);
                String right = input.substring(i + 1);

                List<Integer> left_u = ways(left);
                List<Integer> right_u = ways(right);
                for(int a : left_u){
                    for(int b : right_u){
                        result.add(operate(temp, a, b));
                    }
                }
            }
        }

        if(result.size() == 0){
            result.add(Integer.parseInt(input));
        }
        map.put(input, result);
        return result;
    }

    private int operate(char c, int a, int b){
        switch(c) {
            case '+' :
                return a + b;
            case '-' :
                return a - b;
            case '*' :
                return a * b;
        }
        return 0;
    }

}
