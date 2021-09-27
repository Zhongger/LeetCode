package 数组中的第K个最大元素;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhongmingyi
 * @date 2021/9/27 10:43 下午
 */
public class FindKthLargestSolution {
    public static void main(String[] args) {
        FindKthLargestSolution solution = new FindKthLargestSolution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 2));

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(solution.findKthLargestV2(nums2, 4));

    }

    //API调用法
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //优先队列法，最小堆
    public int findKthLargestV2(int[] nums, int k) {
        //含有k个元素的最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            Integer peek = queue.peek();//堆顶
            if (nums[i] > peek) {
                queue.poll();
                queue.add(nums[i]);
            }
        }

        return queue.peek();

    }


}
