package Day49.合并K个排序数组;

import java.util.ArrayList;
import java.util.Arrays;
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
        int[][] arrayss = {
                {1, 3, 5, 7},
                {2, 4, 6},
                {0, 8, 9, 10, 11}};
        int[] res = solution.merge(arrayss);
        System.out.println(Arrays.toString(res));
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

    public int[] merge(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.val - b.val);//小根堆
        int sum = 0;
        //O(k)时间复杂度得到结果数组的总长度
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {//每个数组的长度大于0
                queue.offer(new Node(i, 0, arrays[i][0]));//将每个数组的最小元素加入堆中（即第一个元素）
                sum += arrays[i].length;
            }
        }
        //这样就得到了k个数组的排序
        int[] res = new int[sum];
        int index = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();//堆顶元素
            res[index] = node.val;
            //当前节点被poll出来后，当前行的第二个节点入堆
            index++;
            if (node.col + 1 < arrays[node.row].length) {//将当前最小值所在的数组下一个元素存入堆
                queue.add(new Node(node.row, node.col + 1, arrays[node.row][node.col + 1]));
            }
        }
        return res;
    }
}

class Node {
    int row;
    int col;
    int val;

    public Node(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}