package Day48.最大数;

import java.util.*;

/**
 * 给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，返回值需要是string类型 否则可能会溢出
 */
public class SolveSolution {
    public String solve(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i ++){
            list.add(String.valueOf(nums[i]));
        }
        //排序
        list.sort((a, b) -> (b + a).compareTo(a + b));//从大到小排序就可以了
        if(list.get(0).equals("0")) return "0";
        StringBuilder res = new StringBuilder(); //结果字符串
        for(int i = 0;i < list.size();i ++){//将排序好后的字符串一次相加就是最终的结果
            res.append(list.get(i));
        }
        return res.toString();
    }


    public static void main(String[] args) {
        SolveSolution solution = new SolveSolution();
        int[] nums = {10, 1};
        String res = solution.solve(nums);
        System.out.println(res);
    }
}
