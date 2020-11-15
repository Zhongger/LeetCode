package Day23.买卖股票的最佳时机;

/**
 * Created by Zhong Mingyi on 2020/11/15.
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 */
public class MaxProfitSolution {
    public static void main(String[] args) {
        MaxProfitSolution solution = new MaxProfitSolution();

    }

    public int maxProfit(int[] prices) {
        int[][] profit = new int[prices.length][2];
        if (prices.length < 2) {
            return 0;
        }
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            profit[i][1] = Math.max(profit[i - 1][1], -prices[i]);
        }
        return profit[prices.length - 1][0];
    }
}
