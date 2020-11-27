package Day25.二叉树的直径;

import common.TreeNode;

/**
 * Created by Zhong Mingyi on 2020/11/27.
 * 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterOfBinaryTreeSolution {
    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDepth;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        maxDepth=Math.max(leftDepth+rightDepth,maxDepth);
        return Math.max(leftDepth,rightDepth)+1;

    }

    public static void main(String[] args) {

    }
}
