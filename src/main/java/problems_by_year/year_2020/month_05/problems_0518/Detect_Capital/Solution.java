package problems_by_year.year_2020.month_05.problems_0518.Detect_Capital;

public class Solution {

    public static void main(String[] args) {
        System.out.println((int)'Z');
        System.out.println('U' < 'u');
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        char firstChar = word.charAt(0);
        if (firstChar > 'Z') {
            for (int i = 1; i < word.toCharArray().length; i++) {
                char c = word.charAt(i);
                if (c < 'a') {
                    return false;
                }
            }
        } else {
            char second = word.charAt(1);
            // 全部小写
            if (second > 'Z') {
                for (int i = 2; i < word.toCharArray().length; i++) {
                    char c = word.charAt(i);
                    // 有一个大写
                    if (c < 'a') {
                        return false;
                    }
                }
            } else {
                for (int i = 2; i < word.toCharArray().length; i++) {
                    char c = word.charAt(i);
                    // 有一个小写
                    if (c > 'Z') {
                        return false;
                    }
                }
            }

        }

        return true;
    }


    public boolean detectCapitalUse_A1(String word) {
        int numUpper = 0;
        for (int i=0;i<word.length();i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                numUpper++;
            }
        }
        if (numUpper == 1) {
            return Character.isUpperCase(word.charAt(0));
        }
        return numUpper == 0 || numUpper == word.length();
    }

}
