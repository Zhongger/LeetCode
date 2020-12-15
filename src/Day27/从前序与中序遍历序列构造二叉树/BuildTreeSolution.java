package Day27.从前序与中序遍历序列构造二叉树;

import common.TreeNode;

import java.util.HashMap;

/**
 * Created by Zhong Mingyi on 2020/12/15.
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
public class BuildTreeSolution {

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        BuildTreeSolution solution = new BuildTreeSolution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        treeNode.print(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int leftPreorderIndex, int rightPreorderIndex,
                          int leftInorderIndex, int rightInorderIndex) {
        if (leftPreorderIndex > rightPreorderIndex) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[leftPreorderIndex]);
        // 在中序遍历中定位根节点
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (root.val == inorder[i]) {
                rootIndex = i;
            }
        }
        int sizeLeft = rootIndex - leftInorderIndex;//得到左子树中的节点数目
        root.left = build(preorder, inorder, leftPreorderIndex + 1, leftPreorderIndex + sizeLeft,
                leftInorderIndex, rootIndex - 1);
        root.right = build(preorder, inorder, leftPreorderIndex + 1 + sizeLeft,
                rightPreorderIndex, rootIndex + 1, rightInorderIndex);

        return root;

    }


}
