package src.string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    /**
     * 时间复杂度为O(n^2)做法
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char j : J.toCharArray()) {
            for (char s : S.toCharArray()) {
                if (j == s) {
                    count++;
                }
            }
        }
        return count;
    }


    // 通过数据结构处理：时间换空间
    public int numJewelsInStones_A1(String J, String S) {
        int res = 0;
        Set jSet = new HashSet();
        for (char j : J.toCharArray()) {
            jSet.add(j);
        }

        for (char s : S.toCharArray()) {
            if (jSet.contains(s)) {
                res++;
            }
        }
        return res;
    }

    // 不需要时间换空间的且复杂度是O(n)：
    public static int numJewelsInStones_A2(String J, String S) {
        int res = 0;
        for (char stone : S.toCharArray()) {
            // 若字符stone在J中存在，计数加上1
            if (J.indexOf(stone) != -1) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String J = "aAc";
        String S = "aAAbcde";
        JewelsAndStones.numJewelsInStones_A3(J, S);

    }

    // 不借助Java API实现O(n)的算法
    public static int numJewelsInStones_A3(String J, String S) {
        // 此处128取值是ASCII码的个数
        int[] list = new int[128];
        int total = 0;
        char[] clist = S.toCharArray();
        for(char c:clist){
            list[(int)c]++;
        }

        char[] jlist = J.toCharArray();
        for(char j:jlist){
            total+=list[(int)j];
        }
        return total;
    }


}
