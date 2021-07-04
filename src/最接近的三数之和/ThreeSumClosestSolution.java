package 最接近的三数之和;

import java.util.Arrays;

public class ThreeSumClosestSolution {
    public static void main(String[] args) {

        int[] nums = {-3, -2, -5, 3, -4};
        ThreeSumClosestSolution solution = new ThreeSumClosestSolution();
        System.out.println(solution.threeSumClosest(nums, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            int second = first + 1;
            int third = n - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    int third_2 = third - 1;
                    while (second < third_2 && nums[third_2] == nums[third]) {
                        third_2--;
                    }
                    third = third_2;
                } else {
                    int second_2 = second + 1;
                    while (second_2 < third && nums[second_2] == nums[second]) {
                        second_2++;
                    }
                    second = second_2;
                }

            }
        }
        return best;
    }
}
