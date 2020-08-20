package problems_by_year.year_2020.month_05.problems_0518.Online_Stock_Span;

import java.util.Stack;

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
public class StockSpanner {

    Stack<int[]> stack;

    /**
     * Input:
     * ["StockSpanner","next","next","next","next","next","next","next"],
     * [[],[100],[80],[60],[70],[60],[75],[85]]
     * Output: [null,1,1,1,2,1,4,6]
     */
    public StockSpanner() {
        this.stack = new Stack<>();
    }

    /**
     * 价格是通过next(price)调用更新的
     * @param price
     * @return
     */
    public int next(int price) {
        int total = 1;
        // >= : 28,24,38
        //      1 ,1 ,1
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            int[] ele = stack.pop();
            total += ele[1];
        }
        stack.push(new int[]{price, total});
        return total;
    }
}
