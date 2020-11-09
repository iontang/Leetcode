package dp.lintcode.p02_dices_sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/5 4:17 下午
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.dicesSum(2);
    }

    /**
     * 可以算长取值的范围，但是不知道怎么计算每个值有多少种组合
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        Map<Integer, Double> resMap = new HashMap<>();
        resMap.put(0,1.0);
        for (int i = 0; i < n; i++) {
            int start = i+1;
            int end = start*6;
            Map<Integer, Double> temp = new HashMap<>();
            for (int j = start; j <= end; j++) {
                for (int k = 1; k <= 6; k++) {
                    int key = j-k;
                    if (resMap.containsKey(key)) {
                        Double value = resMap.get(key);
                        temp.put(j, temp.getOrDefault(j, 0.0) + value*(1/6d));
                    }
                }
            }
            resMap = temp;
        }
        return new ArrayList<>(resMap.entrySet());
    }
}
