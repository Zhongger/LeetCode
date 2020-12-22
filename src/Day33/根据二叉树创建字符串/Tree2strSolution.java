package Day33.根据二叉树创建字符串;

import common.TreeNode;

public class Tree2strSolution {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        Tree2strSolution solution = new Tree2strSolution();
        System.out.println(solution.tree2str(treeNode1));

    }

    public String tree2str(TreeNode t) {
        return helper(t);
    }


    public String helper(TreeNode root) {
        StringBuffer stringBuffer = new StringBuffer();
        if (root == null) {
            return "";
        }
        stringBuffer.append(root.val);
        if (root.left == null && root.right == null) {
            return stringBuffer.toString();
        }
        if (root.right == null) {
            stringBuffer.append("(");
            String left = helper(root.left);
            stringBuffer.append(left);
            stringBuffer.append(")");
            return stringBuffer.toString();
        }
        String left = helper(root.left);
        String right = helper(root.right);
        stringBuffer.append("(");
        stringBuffer.append(left);
        stringBuffer.append(")");
        stringBuffer.append("(");
        stringBuffer.append(right);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

}
