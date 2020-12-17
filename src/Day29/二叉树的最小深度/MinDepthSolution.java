package Day29.二叉树的最小深度;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Zhong Mingyi on 2020/12/17.
 */
public class MinDepthSolution {

    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();//当前节点
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;

    }
}
