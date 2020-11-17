package Day24.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhong Mingyi on 2020/11/16.
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 */
public class FindDisappearedNumberSolution {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();//1~8
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                list.add(i);
            }
        }
        return list;
    }
}
