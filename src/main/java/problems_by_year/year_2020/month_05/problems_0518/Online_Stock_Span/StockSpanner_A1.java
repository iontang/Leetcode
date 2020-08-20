package problems_by_year.year_2020.month_05.problems_0518.Online_Stock_Span;

public class StockSpanner_A1 {

    private int[] pricesStack;
    private int[] spansStack;
    private int top;

    public StockSpanner_A1() {
        pricesStack = new int[10000];
        spansStack = new int[10000];
        top = -1;
    }

    public int next(int price) {
        int span = 1;
        while (0 <= top && pricesStack[top] <= price) {
            span += spansStack[top--];
        }
        top++;
        pricesStack[top] = price;
        spansStack[top] = span;
        return span;
    }

}
