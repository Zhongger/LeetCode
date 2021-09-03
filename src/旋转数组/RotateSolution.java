package 旋转数组;

import java.util.Arrays;

/**
 * @author zhongmingyi
 * @date 2021/9/3 8:41 上午
 */
public class RotateSolution {
    public static void main(String[] args) {
        RotateSolution solution = new RotateSolution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        solution.rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2));


        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        int k3 = 3;
        solution.rotateV2(nums3, k3);
        System.out.println(Arrays.toString(nums3));
    }

    // nums = [1,2,3,4,5,6,7], k = 3
    // 5,6,7,1,2,3,4
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        for (int i = 0; i < k; i++) { //做k次移动
            int lastValue = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = lastValue;
        }

    }

    //正确解法，上面的方法超时了
    public void rotateV2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
