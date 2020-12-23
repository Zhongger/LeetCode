package Day34.叶子相似的树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarSolution {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root1l = new TreeNode(2);
        TreeNode root1r = new TreeNode(3);
        root1.left = root1l;
        root1.right = root1r;

        TreeNode root2 = new TreeNode(2);
        TreeNode root2l = new TreeNode(2);
        TreeNode root2r = new TreeNode(3);
        root2.left = root2l;
        root2.right = root2r;

        LeafSimilarSolution solution = new LeafSimilarSolution();
        System.out.println(solution.leafSimilar(root1, root2));

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        getLeafValueStr(root1, leaves1);
        getLeafValueStr(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void getLeafValueStr(TreeNode root, List<Integer> leafValues) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leafValues.add(root.val);
            }
            getLeafValueStr(root.left, leafValues);
            getLeafValueStr(root.right, leafValues);
        }
    }
}
