package Day38.连续数列;

import java.util.Arrays;

public class MaxSubArraySolution {
    public static void main(String[] args) {
        MaxSubArraySolution solution = new MaxSubArraySolution();
        int[] nums = {-2,1};
        System.out.println(solution.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {

            nums[i]+=Math.max(nums[i-1],0);
            result=Math.max(result,nums[i]);
        }
        return result;

    }
}
