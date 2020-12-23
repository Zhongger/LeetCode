package Day34.检查平衡性;

import common.TreeNode;

public class IsBalancedSolution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(20);
        root.left = root1;
        root.right = root2;

        TreeNode root21 = new TreeNode(15);
        TreeNode root22 = new TreeNode(7);
        root2.left = root21;
        root2.right = root22;

        IsBalancedSolution solution = new IsBalancedSolution();
        System.out.println(solution.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }else {
            return Math.abs(getHeight(root.left)-getHeight(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
        }
    }

    public int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
}
