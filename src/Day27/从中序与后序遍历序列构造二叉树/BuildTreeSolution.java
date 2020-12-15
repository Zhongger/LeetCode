package Day27.从中序与后序遍历序列构造二叉树;

import common.TreeNode;

import java.util.HashMap;

/**
 * Created by Zhong Mingyi on 2020/12/15.
 */
public class BuildTreeSolution {

    private int postorderIndex;

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        BuildTreeSolution solution = new BuildTreeSolution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = solution.buildTree(inorder, postorder);
        treeNode.print(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postorderIndex = postorder.length - 1;
        return build(inorder, postorder,
                0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder,
                          int inorderLeft, int inorderRight
                          ) {
        if (inorderLeft > inorderRight) {
            return null;
        }
        //根节点
        int postorderRootIndex = postorderIndex;
        TreeNode root = new TreeNode(postorder[postorderRootIndex]);

        //中序遍历中，根节点的下标
        Integer index = map.get(postorder[postorderRootIndex]);


        postorderIndex--;
        //主要要先构造右子树
        root.right=build(inorder,postorder,index+1,inorderRight);
        root.left=build(inorder,postorder,inorderLeft,index-1);

        return root;
    }
}
