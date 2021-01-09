package Day42.全排列;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermuteSolution {

    private List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            output.add(nums[i]);
        }
        helper(output,nums.length,0);
        return resList;
    }

    public void helper( List<Integer> output, int length ,int first){
        if (length==first){
            resList.add(new ArrayList<>(output));
        }
        for (int i = first; i < length; i++) {
            Collections.swap(output,first,i);
            helper(output,length,first+1);
            Collections.swap(output,first,i);
        }
    }
}
