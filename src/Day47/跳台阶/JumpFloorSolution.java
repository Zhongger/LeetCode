package Day47.跳台阶;

public class JumpFloorSolution {
    public static void main(String[] args) {
        JumpFloorSolution solution = new JumpFloorSolution();
        System.out.println(solution.jumpFloor2(4));
    }

    //动态规划
    public int jumpFloor(int target) {
        if (target < 1) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    //滚动数组
    public int jumpFloor2(int target) {
        int a = 1, b = 1, sum = 0;
        if (target == 0 || target == 1) {
            return 1;
        }
        while (target >= 2) {
            sum = a + b;
            b = a;
            a = sum;
            target--;
        }

        return sum;

    }
}
