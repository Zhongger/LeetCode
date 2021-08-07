package 子数组最大平均数1;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class FindMaxAverageSolution {
    public static void main(String[] args) {
        FindMaxAverageSolution solution = new FindMaxAverageSolution();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double res = solution.findMaxAverage(nums, k);
        System.out.println(res);

        int[] nums2 = {-1};
        int k2 = 1;
        double res2 = solution.findMaxAverage(nums2, k2);
        System.out.println(res2);
    }

    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        int max = Integer.MIN_VALUE;
        while (right < nums.length) {
            int sum = getSum(nums, left, right);
            if (max < sum) {
                max = sum;
            }
            right++;
            left++;
        }
        return (double) max / k;
    }

    public int getSum(int[] nums, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public double findMaxAverage2(int[] nums, int k) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return 1.0 * maxSum / k;
    }


}
