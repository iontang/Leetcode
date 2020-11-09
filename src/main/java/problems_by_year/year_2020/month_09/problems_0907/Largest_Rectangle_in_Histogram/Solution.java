package problems_by_year.year_2020.month_09.problems_0907.Largest_Rectangle_in_Histogram;

// 84:
// Largest Rectangle in Histogram
// largest-rectangle-in-histogram

//Given n non-negative integers representing the histogram's bar height where th
//e width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//
//
//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
//].
//
//
//
//
//The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
// Example:
//
//
//Input: [2,1,5,6,2,3]
//Output: 10
//
// Related Topics Array Stack
// 👍 4187 👎 93

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName Solution
 *
 * @version 1.0
 * @Author: ion
 * @Date: 2020/9/9 1:47 下午
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.largestRectangleArea_A1(new int[]{2,1,5,6,2,3});
    }

    /**
     * [2,1,5,6,2,3]
     * 如果高度 <= 前一个的高度，高度取最低高度，宽度在前一个宽度的基础上+1；
     * 如果高度 > 前一个, 比较 1*高度 >  前一个高度*（前一个宽度+1） ？ 前者 ： 后者；然后更新宽度和高度
     *
     * 反例：如果高度是5，宽度是2的面积是局部最大，后面存在高度是1，宽度是11的，上面算法就出错了
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = 1;
            int minHeight = heights[i];
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight*width);
                width++;
            }
        }
        return maxArea;
    }

    public int largestRectangleArea_W1(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(len);
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int cur = stack.peekLast();
                stack.pollLast();
                int left = stack.peekLast() + 1;
                int right = i +1;
                maxArea = Math.max(maxArea, (right - left +1)*heights[cur]);
            }
            stack.addLast(i);
        }
        return maxArea;
    }

    /**
     * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/28900/Short-and-Clean-O(n)-stack-based-JAVA-solution
     * @param heights
     * @return
     */
    public int largestRectangleArea_A1(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(len);
        int maxArea = 0;
        // 遍历的长度是数组的长度+1
        for (int i = 0; i <= len; i++){
            // 有一个虚拟的结束位置，大小是0；
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peekLast()]) {
                stack.addLast(i);
            } else {
                int tp = stack.pollLast();
                // 两边都不算，只算中间的距离，所以减 1）
                int width = (stack.isEmpty() ? i : i - 1 - stack.peekLast());
                maxArea = Math.max(maxArea, heights[tp] * width);
                // 保持原始位置不变。
                i--;
            }
        }
        return maxArea;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

