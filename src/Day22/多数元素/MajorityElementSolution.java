package Day22.多数元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementSolution {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElementSolution solution = new MajorityElementSolution();
        System.out.println(solution.majorityElement3(nums));
    }
    //哈希表法
    public int majorityElement(int[] nums) {
        int min = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        Integer key = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>min){
                key =  entry.getKey();
            }
        }
        return key;
    }

    //排序法
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //摩尔投票法
    public int majorityElement3(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count==0){
                candidate=nums[i];
            }
            if (nums[i]==candidate){
                count+=1;
            }else {
                count-=1;
            }
        }
        return candidate;
    }
}
