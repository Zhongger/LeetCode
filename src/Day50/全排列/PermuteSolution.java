package Day50.全排列;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PermuteSolution {
    private List<List<Integer>> resList = new ArrayList<>();

    public static void main(String[] args) {
        PermuteSolution solution = new PermuteSolution();
        int[] nums = {1,2,3};
        solution.permute(nums);
        System.out.println(solution.resList);
    }

    public List<List<Integer>> permute(int[] nums) {
         Deque<Integer> traceList = new LinkedList<>();
         getTrace(nums,traceList);
         return resList;
    }

    public void getTrace(int[] nums,Deque<Integer> traceList){
        if (nums.length==traceList.size()){
            resList.add(new LinkedList<>(traceList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (traceList.contains(nums[i])){
                continue;
            }
            traceList.add(nums[i]);
            getTrace(nums, traceList);
            traceList.removeLast();
        }
    }
}
