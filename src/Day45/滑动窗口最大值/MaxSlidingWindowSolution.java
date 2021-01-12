package Day45.滑动窗口最大值;

import java.util.PriorityQueue;

public class MaxSlidingWindowSolution {
    public static void main(String[] args) {
        MaxSlidingWindowSolution solution = new MaxSlidingWindowSolution();
        int[] nums = {4,-2};
        int k = 2;
        int[] res = solution.maxSlidingWindow(nums, k);
        for (int i = 0; i < res.length; i++) {
            System.out.printf(res[i]+" ");
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);//最大堆
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i],i});
        }
        int[] res = new int[nums.length - k + 1];//结果数组的长度
        res[0]=queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i],i});
            while (queue.peek()[1]<=i-k){
                queue.poll();
            }
            res[i-k+1]=queue.peek()[0];
        }
        return res;
    }
}
