package Day01.两数之和;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Zhong Mingyi on 2020/8/26.
 * 两数之和：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */

/**
 * 复杂度分析：
 * 时间：
 *      O(n),把n个元素的列表遍历两次，由于哈希表将查找时间缩短到O(1)，故时间复杂度为O(n)
 * 空间：
 *      所需额外的空间取决于哈希表中存储元素的数量，由于存了n个entry，故空间复杂度为O(n)
 */
public class TwoSumSolution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int secondNum = target - nums[i];
            if (map.containsKey(secondNum) && map.get(secondNum) != i) {
                return new int[]{i, map.get(secondNum)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

