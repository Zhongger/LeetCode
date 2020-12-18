package Day30.对称的二叉树;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhong Mingyi on 2020/12/18.
 */
public class IsSymmetricSolution {

    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) {
        IsSymmetricSolution solution = new IsSymmetricSolution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;


        TreeNode root2 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        TreeNode node24 = new TreeNode(3);
        root2.left=node21;
        root2.right=node22;

        node21.right=node23;
        node22.right=node24;



//        System.out.println(solution.isSymmetric(root));
//
//        System.out.println(solution.isSymmetric(root2));

      //  System.out.println(solution.isSymmetric(null));

        System.out.println(solution.isSymmetric(null));
    }

    public boolean isSymmetric(TreeNode root) {
        helper1(root);
        helper2(root);
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i)!=list2.get(i)){
                return false;
            }
        }
        return true;
    }

    public void helper1(TreeNode root) {
        if (root == null) {
            list1.add(0);
            return;
        }
        list1.add(root.val);
        helper1(root.left);
        helper1(root.right);
    }

    public void helper2(TreeNode root) {
        if (root == null) {
            list2.add(0);
            return;
        }
        list2.add(root.val);
        helper2(root.right);
        helper2(root.left);
    }

    //正确的做法：

    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.val == root2.val && helper(root1.left, root2.right) &&
                helper(root1.right, root2.left);
    }
}
