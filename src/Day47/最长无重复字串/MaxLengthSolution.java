package Day47.最长无重复字串;

import java.util.HashMap;

public class MaxLengthSolution {

    public static void main(String[] args) {
        MaxLengthSolution solution = new MaxLengthSolution();
        int[] arr = {2, 2, 3, 4, 3};
        System.out.println(solution.maxLength(arr));
    }

    //滑动窗口法
    public int maxLength(int[] arr) {
        // write code here
        if (arr.length < 2) {
            return arr.length;
        }
        int res = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])) {
                start = Math.max(start, map.get(arr[end]) + 1);
            }
            res = Math.max(res, end - start + 1);
            map.put(arr[end], end);
        }
        return res;

    }

    //双指针+回头遍历法
    public int maxLength2(int[] arr) {
        int res = 0;
        int temp = 0;
        for (int right = 0; right < arr.length; right++) {
            int left = right - 1;
            //回头扫描，要是没有找到相同的，左指针一直倒退
            while (left >= 0 && arr[left] != arr[right]) {
                left--;
            }
            //找到了
            //暂时保存子串长度
            //若指针距离比上一个字符时拥有的子串长度大，就tmp + 1，否则就设置为指针距离，方便下一步res进行比较
            temp = temp < right - left ? temp + 1 : right - left;
            res = Math.max(res, temp);
        }
        return res;
    }
}
