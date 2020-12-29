package Day39.三步问题;

public class WaysToStepSolution {


    public int waysToStep(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = ((dp[i - 2] + dp[i - 3]) % 1000000007 + dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }

    //滚动数组
    public int waysToStep2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int x = 4;
        int y = 2;
        int z = 1;
        for (int i = 0; i < n - 3; i++) {
            int temp_x = x;
            int temp_y = y;
            x = ((y + z) % 1000000007 + temp_x) % 1000000007;
            y = temp_x;
            z = temp_y;
        }
        return x;
    }
}
