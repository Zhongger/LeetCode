package 最小K个数;

import java.util.Arrays;

/**
 * @author zhongmingyi
 * @date 2021/9/3 8:13 上午
 */
public class SmallestKSolution {
    public static void main(String[] args) {
        SmallestKSolution solution = new SmallestKSolution();
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        System.out.println(Arrays.toString(solution.smallestK(arr, 4)));
    }

    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
