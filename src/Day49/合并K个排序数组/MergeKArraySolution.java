package Day49.合并K个排序数组;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKArraySolution {
    public static void main(String[] args) {
        MergeKArraySolution solution = new MergeKArraySolution();
        int[] arr1 = {1, 4, 5};
        int[] arr2 = {1, 3, 4};
        int[] arr3 = {2, 6};
        List<int[]> arrays = new ArrayList<>();
        arrays.add(arr1);
        arrays.add(arr2);
        arrays.add(arr3);
        solution.merge(arrays);
    }

    public void merge(List<int[]> arrays) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arrays.size(); i++) {
            for (int j = 0; j < arrays.get(i).length; j++) {
                queue.offer(arrays.get(i)[j]);
            }
        }
        //O(Nlogk);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        System.out.println(list);
    }
}
