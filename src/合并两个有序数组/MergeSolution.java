package 合并两个有序数组;

import java.util.Arrays;

public class MergeSolution {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0};
        int[] nums2 = {4, 5};
        MergeSolution solution = new MergeSolution();
        solution.merge3(nums1, 3, nums2, 2);
        System.out.println(Arrays.toString(nums1));


    }

    //简单除暴，暴力求解。先插入，后排序。
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //利用临时数组，移动次数比较多
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        int q = 0;
        int cur = 0;
        int[] res = new int[m + n];
        while (p < m || q < n) {
            if (p == m) {
                cur = nums2[q];
                q++;
            } else if (q == n) {
                cur = nums1[p];
                p++;
            } else if (nums1[p] < nums2[q]) {
                cur = nums1[p];
                p++;
            } else {
                cur = nums2[q];
                q++;
            }
            res[p + q - 1] = cur;
        }

        for (int i = 0; i < (m + n); i++) {
            nums1[i] = res[i];
        }
    }

    //原地修改
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int tail = m + n - 1;
        int cur = 0;
        while (p >= 0 || q >= 0) {
            if (p == -1) {
                cur = nums2[q];
                q--;
            } else if (q == -1) {
                cur = nums1[p];
                p--;
            } else if (nums1[p] < nums2[q]) {
                cur = nums2[q];
                q--;
            } else {
                cur = nums1[p];
                p--;
            }
            nums1[tail] = cur;
            tail--;
        }
    }

    public static void backToNext(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int right = nums.length - 1;
        while (right >= 0) {
            if (nums[right] != 0) {
                nums[right + 1] = nums[right];
            }
            right--;
        }
        nums[0] = 0;
    }

}
