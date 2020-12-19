package Day31.二叉树中和为某一值的路径;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSumSolution {

    private List<List<Integer>> resPath = new LinkedList<>();
    private Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        getPath(root,sum,0);
        return resPath;
    }

    public void getPath(TreeNode root, int sum, int tempSum) {
        if (root == null) {
            return;
        }

        tempSum += root.val;
        path.add(root.val);
        if (tempSum==sum&&root.left==null&&root.right==null){
           resPath.add(new LinkedList<>(path));
        }
        getPath(root.left,sum,tempSum);
        getPath(root.right,sum,tempSum);
        path.removeLast();
    }
}
