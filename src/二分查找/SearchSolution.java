package 二分查找;

/**
 * @author zhongmingyi
 * @date 2021/9/2 8:54 上午
 */
public class SearchSolution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int flag;
        while (left <= right) {
            flag = left + (right - left) / 2;
            if (nums[flag] == target) return flag;
            if (nums[flag] < target) {
                left = flag + 1;
            } else {
                right = flag - 1;
            }
        }
        return -1;
    }


}
