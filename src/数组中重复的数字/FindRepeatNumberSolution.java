package 数组中重复的数字;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * @author zhongmingyi
 * @date 2021/11/10 9:21 下午
 */
public class FindRepeatNumberSolution {
    public static void main(String[] args) {
        FindRepeatNumberSolution solution = new FindRepeatNumberSolution();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(solution.findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    res = nums[i];
                    return res;
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return res;
    }
}
