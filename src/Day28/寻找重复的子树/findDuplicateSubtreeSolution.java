package Day28.寻找重复的子树;

import common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhong Mingyi on 2020/12/16.
 */
public class findDuplicateSubtreeSolution {

    private HashMap<String, Integer> map = new HashMap<>();
    private List<TreeNode> resList = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        transfer(root);
        return resList;
    }

    public String transfer(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftStr = transfer(root.left);
        String rightStr = transfer(root.right);

        String subTree = leftStr + "," + rightStr + "," + root.val;
        Integer times = map.getOrDefault(subTree, 0);//出现次数
        if (times == 1) {
            resList.add(root);
        }
        map.put(subTree, times + 1);
        return subTree;
    }
}
