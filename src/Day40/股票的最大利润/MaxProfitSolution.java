package Day40.股票的最大利润;

public class MaxProfitSolution {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if (prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
