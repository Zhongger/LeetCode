package 斐波那契数列;

/**
 * @author zhongmingyi
 * @date 2021/9/4 11:38 上午
 */
public class FibSolution {
    public static void main(String[] args) {
        FibSolution solution = new FibSolution();
        System.out.println(solution.fib(2));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        final int MOD = 1000000007;
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i < ans.length; i++) {
            ans[i] = (ans[i - 1] + ans[i - 2]) % MOD;
        }
        return ans[n];
    }
}
