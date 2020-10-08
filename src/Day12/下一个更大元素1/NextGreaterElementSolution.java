package Day12.下一个更大元素1;

import java.util.*;

public class NextGreaterElementSolution {
    public static void main(String[] args) {
        NextGreaterElementSolution solution = new NextGreaterElementSolution();
        int[] nums1 = {2,4};
        Stack<Integer> stack = new Stack<>();

        int[] nums2 = {1,2,3,4};
        int[] res = solution.nextGreaterElement2(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    /**
     * 暴力求解法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            int[] arr = new int[0];

            return arr;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list2.add(nums2[i]);
        }
        for (Integer num : list1) {
            int index = list2.indexOf(num);
            boolean flag = false;
            for (int i = index; i < list2.size(); i++) {
                if (list2.get(i)>num){
                    flag = true;
                    resList.add(list2.get(i));
                    break;
                }
            }
            if (!flag){
                resList.add(-1);
            }

        }
        int[] resArr = new int[nums1.length];
        for (int i = 0; i < resArr.length; i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }

    /**
     * 单调栈法
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty()&&nums2[i]>stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;

    }
}
