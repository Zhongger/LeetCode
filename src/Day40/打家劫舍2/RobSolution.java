package Day40.打家劫舍2;

import java.util.Arrays;

public class RobSolution {
    public static void main(String[] args) {
        RobSolution solution = new RobSolution();
        int[] nums  ={4,1,2,7,5,3,1};
        System.out.println(solution.rob(nums));
    }


    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int[] arr1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1, nums.length );

        int res1 = help(arr1);
        int res2 = help(arr2);
        return Math.max(res1,res2);
    }

    public int help(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
