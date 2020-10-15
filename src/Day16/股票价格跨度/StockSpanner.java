package Day16.股票价格跨度;

import java.util.Stack;

/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 */
public class StockSpanner {
    private Stack<Integer> priceStack;
    private Stack<Integer> weightStack;

    public StockSpanner() {
        priceStack = new Stack<>();
        weightStack = new Stack<>();
    }
    /**
     * 单调栈解法
     * @param price
     * @return
     */
    public int next(int price) {
        int w = 1;
        while (!priceStack.isEmpty() && priceStack.peek() <= price) {
            priceStack.pop();
            w += weightStack.pop();
        }
        priceStack.push(price);
        weightStack.push(w);
        return w;
    }
}
