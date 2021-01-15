package Day47.子数组的最大累加和问题;

public class MaxsumofSubarraySolution {
    public static void main(String[] args) {
        MaxsumofSubarraySolution solution = new MaxsumofSubarraySolution();
        int[] arr= {1, -2, 3, 5, -2, 6, -1};
        System.out.println(solution.maxsumofSubarray(arr));
    }
    public int maxsumofSubarray (int[] arr) {
        int res = arr[0];
        for(int i = 1; i < arr.length; i++) {
            arr[i] += Math.max(arr[i - 1], 0);
            res = Math.max(res, arr[i]);
        }
        return res;

    }

}
