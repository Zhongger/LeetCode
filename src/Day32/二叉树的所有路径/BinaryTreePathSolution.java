package Day32.二叉树的所有路径;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class BinaryTreePathSolution {

    private List<String> resList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);

        root.left = node;
        root.right = node2;
        node.right = node1;

        BinaryTreePathSolution solution = new BinaryTreePathSolution();
        List<String> list = solution.binaryTreePaths(root);
        System.out.println(list.toString());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root,"");
        return resList;
    }

    public void helper(TreeNode root,String path) {
        if (root == null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer(path);
        stringBuffer.append(root.val);
        if (root.left==null&&root.right==null){
            resList.add(stringBuffer.toString());
        }else {
            stringBuffer.append("->");
            helper(root.left, stringBuffer.toString());
            helper(root.right,stringBuffer.toString());
        }
    }
}
