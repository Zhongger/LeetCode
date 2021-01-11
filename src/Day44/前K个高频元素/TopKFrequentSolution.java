package Day44.前K个高频元素;

import java.util.*;

public class TopKFrequentSolution {

    public static void main(String[] args) {
        TopKFrequentSolution solution = new TopKFrequentSolution();
        int[] nums = {5, 2, 5, 3, 5, 3, 1, 1, 3};
        int k = 2;
        int[] res = solution.topKFrequent(nums, k);
        for (int i : res) {
            System.out.println(i);
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((v1, v2) -> map.get(v1) - map.get(v2)); // 定义小根堆，根据数字频率自小到大排序
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer count = entry.getValue();
            if (k > queue.size()) {
                queue.offer(key);
            } else if (map.get(queue.peek()) < count) {
                queue.poll();
                queue.offer(key);
            }
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(queue);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
