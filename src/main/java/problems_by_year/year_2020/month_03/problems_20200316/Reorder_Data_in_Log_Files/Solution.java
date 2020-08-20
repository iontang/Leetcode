package problems_by_year.year_2020.month_03.problems_20200316.Reorder_Data_in_Log_Files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    public static void main(String[] args) {
        String ss = "1,2,";
        String sss[] = ss.split(",", 2);
        System.out.println(sss.length);

        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
//        String log = "let1 art can";
//        int s1SpaceIndex = log.indexOf(' ');
//        System.out.println(log.charAt(s1SpaceIndex+1));
//
//        System.out.println(log.substring(0, log.indexOf(" ")));
//        System.out.println(log.substring(log.indexOf(" ")));
//
//        String[] split1 = log.split(" ", 2);
//        for (String s : split1) {
//            System.out.println(s);
//        }
//        System.out.println(split1);

        Solution solution = new Solution();
//        solution.reorderLogFiles_A1(logs);
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

        solution.reorderLogFiles(logs);
    }

    /**
     * two varieties of logs letter-logs and digit-logs.
     * 输入如果是下面的情况，就会出错：
     * ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
     * @param logs
     * @return
     */
    public String[] reorderLogFiles_W1(String[] logs) {
        String[] digArr = new String[logs.length];
        List<String> letters = new ArrayList<>();
        int index = logs.length-1;
        for (int i = logs.length-1; i>=0; i--) {
            if (logs[i].startsWith("dig")) {
                digArr[index] = logs[i];
                --index;
            } else {
                letters.add(logs[i]);
            }
        }

        Comparator<String> myComp = (s2, s1) -> {
//                System.out.println("=== s1=" + s1 + "  ===s2 =" + s2 );
                int s2SpaceIndex = s2.indexOf(' ');
                int s1SpaceIndex = s1.indexOf(' ');
                // s1, s2都是let-log，比较它们的后半部分。
                int preCompute = s2.substring(s2SpaceIndex+1).compareTo(s1.substring(s1SpaceIndex+1));
//                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                System.out.println(preCompute);
                // 后半部分相等，比较前缀
                if (preCompute == 0) return s2.substring(0,s2SpaceIndex).compareTo(s1.substring(0,s1SpaceIndex));
                return preCompute;
        };
//
        String[] s = letters.toArray(new String[0]);
        Arrays.sort(letters.toArray(new String[0]), myComp);
//        Arrays.sort(s, myComp);
//        for (String s1 : s) {
//            System.out.println(s1);
//
//        }
        for (int i=0; i<s.length; i++) {
            digArr[i] = s[i];
        }
        return digArr;
    }


    /**
     * modify from W1 answer.
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        String[] digArr = new String[logs.length];
        List<String> letters = new ArrayList<>();
        int index = logs.length-1;
        for (int i = logs.length-1; i>=0; i--) {
            int spaceIndex = logs[i].indexOf(' ');
            char c = logs[i].charAt(spaceIndex+1);
            if (c <= '9') {
                digArr[index] = logs[i];
                --index;
            } else {
                letters.add(logs[i]);
            }
        }

        Comparator<String> myComp = (s2, s1) -> {
            int s2SpaceIndex = s2.indexOf(' ');
            int s1SpaceIndex = s1.indexOf(' ');
            int preCompute = s2.substring(s2SpaceIndex+1).compareTo(s1.substring(s1SpaceIndex+1));
            if (preCompute == 0) return s2.substring(0,s2SpaceIndex).compareTo(s1.substring(0,s1SpaceIndex));
            return preCompute;
        };

        String[] s = letters.toArray(new String[0]);
        Arrays.sort(s, myComp);
        for (int i=0; i<s.length; i++) {
            digArr[i] = s[i];
        }
        return digArr;
    }

    public String[] reorderLogFiles_A1(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s2, String s1) {
                int s2SpaceIndex = s2.indexOf(' ');
                int s1SpaceIndex = s1.indexOf(' ');
                char s2FirstCharacter = s2.charAt(s2SpaceIndex+1);
                char s1FirstCharacter = s1.charAt(s1SpaceIndex+1);
                if (s2FirstCharacter <= '9') {
                    if (s1FirstCharacter <= '9') return 0; // 都是dig-log， 不交换
                    else return 1; // s2是dig-log , s1是let-log, 不交换
                }
                if (s1FirstCharacter <= '9') return -1; // s1是dig-log, s2是let-leg，交换

                // s1, s2都是let-log，比较它们的后半部分。
                int preCompute = s2.substring(s2SpaceIndex+1).compareTo(s1.substring(s1SpaceIndex+1));
                // 后半部分相等，比较前缀
                if (preCompute == 0) return s2.substring(0,s2SpaceIndex).compareTo(s1.substring(0,s1SpaceIndex));
                return preCompute;
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }

}
