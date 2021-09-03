package 有序数组的平方;

/**
 * @author zhongmingyi
 * @date 2021/9/3 8:21 上午
 */
public class SortedSquareSolution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int flag = -1;
        //找到最后一个小于0的数字，作为原数组的分界线
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                flag = i;
            } else {
                break;
            }
        }
//        -4,-1,
//                0,3,10
//         两个有序数组做归并排序
        int i = flag; //负数数组的最后一个元素
        int j = flag + 1; //正数数组的第一个元素
        int index = 0;
        while (i >= 0 || j < n) {
            if (i < 0) {
                res[index] = nums[j] * nums[j];
                j++;
            } else if (j == n) {
                res[index] = nums[i] * nums[i];
                i--;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[index] = nums[i] * nums[i];
                i--;
            } else {
                res[index] = nums[j] * nums[j];
                j++;
            }
            index++;
        }
        return res;

    }
}
