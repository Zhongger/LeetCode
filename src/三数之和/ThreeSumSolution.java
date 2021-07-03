package 三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSolution {
    public static void main(String[] args) {
        ThreeSumSolution solution = new ThreeSumSolution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = solution.threeSum(nums);
        System.out.println(res.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 确保third在second的右侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                //若指针重合，则不可能再有b<c的c了
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

}
