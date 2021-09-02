package 搜索插入位置;

/**
 * @author zhongmingyi
 * @date 2021/9/2 2:37 下午
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 */
public class SearchInsertSolution {
    public static void main(String[] args) {
        SearchInsertSolution solution = new SearchInsertSolution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int flag = 0;
        int ans = nums.length;
        while (left <= right) {
            flag = left + (right - left) / 2;
            if (target <= nums[flag]) {
                ans = flag;
                right = flag - 1;
            } else {
                left = flag + 1;
            }
        }
        return ans;
    }
}
