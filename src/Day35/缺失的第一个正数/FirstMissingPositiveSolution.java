package Day35.缺失的第一个正数;

public class FirstMissingPositiveSolution {
    public static void main(String[] args) {
        FirstMissingPositiveSolution solution = new FirstMissingPositiveSolution();
        int[] nums = {1,2,0};
        System.out.println(solution.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
