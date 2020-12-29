package Day39.连续子数组的最大和;

public class MaxSubArraySolution {
    public int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i]=nums[i]+Math.max(nums[i-1],0);
            res=Math.max(res,nums[i]);
        }
        return res;
    }
}
