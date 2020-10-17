package Day17.除自身以外数组的乘积;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductExceptSelfSolution {
    public static void main(String[] args) {
        ProductExceptSelfSolution solution = new ProductExceptSelfSolution();
        int[] nums = {1,2,3,4};
        int[] res = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
    public int[] productExceptSelf (int[] nums) {
        int[] res = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i,nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int resNum = 1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey().equals(i)){
                    continue;
                }else {
                    resNum*=entry.getValue();
                }
            }
            res[i]=resNum;
        }
        return res;
    }
}
