package Day42.二叉树中的最大路径和;

import common.TreeNode;

public class MaxPathSumSolution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        great(root);
        return maxSum;
    }

    public int great(TreeNode root){
        if (root==null){
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(great(root.left), 0);
        int right = Math.max(great(root.right), 0);
        //最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewPath = root.val+left+right;
        // 更新答案
        maxSum=Math.max(maxSum,priceNewPath);
        // 返回节点的最大贡献值
        return root.val+Math.max(left,right);
    }

}
