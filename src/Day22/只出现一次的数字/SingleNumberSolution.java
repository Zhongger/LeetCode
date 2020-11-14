package Day22.只出现一次的数字;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumberSolution {
    public static void main(String[] args) {
        SingleNumberSolution solution = new SingleNumberSolution();
        int[] nums = new int[]{2, 2, 1, 3, 3};
        System.out.println(solution.singleNumber(nums));
    }

    //使用异或的性质
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
