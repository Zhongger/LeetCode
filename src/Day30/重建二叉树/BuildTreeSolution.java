package Day30.重建二叉树;

import common.TreeNode;

import java.util.HashMap;

/**
 * Created by Zhong Mingyi on 2020/12/18.
 */
public class BuildTreeSolution {

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return build(preorder,inorder,0, preorder.length-1,0, inorder.length-1 );
    }

    public TreeNode build(int[] preorder, int[] inorder, int leftPreorderIndex, int rightPreorderIndex,
                          int leftInorderIndex, int rightInorderIndex) {
        if (leftPreorderIndex > rightPreorderIndex) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[leftPreorderIndex]);
        Integer index = map.get(preorder[leftPreorderIndex]);
        int leftSize = index - leftInorderIndex;
        root.left = build(preorder, inorder, leftPreorderIndex + 1, leftPreorderIndex + leftSize,
                leftInorderIndex, leftSize - 1);
        root.right = build(preorder, inorder, leftPreorderIndex + 1 + leftSize, rightPreorderIndex,
                index + 1, rightInorderIndex);
        return root;
    }


}
