package Day20.最大子序和;

/**
 * Created by Zhong Mingyi on 2020/11/12.
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArraySolution {
    public int maxSubArray(int[] nums) {
        int thisSum = 0, maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
           thisSum = Math.max(thisSum+nums[i],nums[i]);
           maxSum = Math.max(maxSum,thisSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArraySolution solution = new MaxSubArraySolution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {-3, -2, 0, -1};
        System.out.println(solution.maxSubArray(nums));
    }
}
