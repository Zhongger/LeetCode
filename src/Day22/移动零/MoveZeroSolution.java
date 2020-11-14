package Day22.移动零;

public class MoveZeroSolution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZeroSolution solution = new MoveZeroSolution();
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.printf(num+" ");
        }
    }
}
