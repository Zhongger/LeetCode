package Day12.下一个更大元素2;

import java.util.Stack;

public class NextGreaterElementSolution {
    public static void main(String[] args) {
        NextGreaterElementSolution solution = new NextGreaterElementSolution();
        int[] nums = {1, 2, 3, 4, 5};
        int[] res = solution.nextGreaterElements(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()&&nums[i%nums.length]>=nums[stack.peek()]){
                stack.pop();
            }
            res[i%nums.length]=stack.isEmpty()?-1:nums[stack.peek()];
            stack.push(i%nums.length);
        }
        return res;
    }
}
