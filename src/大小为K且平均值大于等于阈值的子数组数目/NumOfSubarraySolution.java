package 大小为K且平均值大于等于阈值的子数组数目;

/**
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 */
public class NumOfSubarraySolution {
    public static void main(String[] args) {
        NumOfSubarraySolution solution = new NumOfSubarraySolution();
        int[] arr1 = {2, 2, 2, 2, 5, 5, 5, 8};
        int k1 = 3;
        int threshold1 = 4;
        System.out.println(solution.numOfSubarrays(arr1, k1, threshold1));

        int[] arr2 = {1, 1, 1, 1, 1};
        int k2 = 1;
        int threshold2 = 0;
        System.out.println(solution.numOfSubarrays(arr2, k2, threshold2));

        int[] arr3 = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k3 = 3;
        int threshold3 = 5;
        System.out.println(solution.numOfSubarrays(arr3, k3, threshold3));

        int[] arr4 = {7, 7, 7, 7, 7, 7, 7};
        int k4 = 7;
        int threshold4 = 7;
        System.out.println(solution.numOfSubarrays(arr4, k4, threshold4));

        int[] arr5 = {4, 4, 4, 4};
        int k5 = 4;
        int threshold5 = 15;
        System.out.println(solution.numOfSubarrays(arr5, k5, threshold5));

    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int sum = 0;
        int sumTarget = k * threshold;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= sumTarget) {
            res++;
        }
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            if (sum >= sumTarget) {
                res++;
            }
        }
        return res;

    }
}
