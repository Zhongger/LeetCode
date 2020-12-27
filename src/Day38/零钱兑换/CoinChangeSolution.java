package Day38.零钱兑换;

import java.util.Arrays;

public class CoinChangeSolution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1]; //当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
        Arrays.fill(dp,amount+1);//初始化dp
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i-coin<0) continue;
                dp[i]=Math.min(dp[i],1+dp[i-coin]);
            }
        }

        if (dp[amount]==amount+1){
            return -1;
        }else {
            return dp[amount];
        }
    }
}
