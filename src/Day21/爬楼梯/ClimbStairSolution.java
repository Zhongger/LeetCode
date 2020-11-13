package Day21.爬楼梯;

/**
 * Created by Zhong Mingyi on 2020/11/13.
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 */
public class ClimbStairSolution {

    //动态规划解法
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];

    }
    //空间复杂度优化
    public int climbStairs2(int n) {
        int pre = 1;
        int preOfPre=1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
           cur=pre+preOfPre;
           preOfPre=pre;
           pre=cur;
        }
        return cur;

    }

    public static void main(String[] args) {
        ClimbStairSolution climbStairSolution = new ClimbStairSolution();
        System.out.println(climbStairSolution.climbStairs(3));
    }
}
