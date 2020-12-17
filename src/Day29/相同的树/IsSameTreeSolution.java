package Day29.相同的树;

import common.TreeNode;

/**
 * Created by Zhong Mingyi on 2020/12/17.
 */
public class IsSameTreeSolution {


    public static void main(String[] args) {
        IsSameTreeSolution solution = new IsSameTreeSolution();
        TreeNode p = new TreeNode(1);
        TreeNode pl = new TreeNode(2);
        TreeNode pr = new TreeNode(3);
        p.left = pl;
        p.right = pr;


        TreeNode q = new TreeNode(1);
        TreeNode ql = new TreeNode(2);
        TreeNode qr = new TreeNode(3);
        q.left = ql;
        //q.right = qr;

        System.out.println(solution.isSameTree(p,q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        String pStr = transfer(p);
        String qStr = transfer(q);
        return pStr.equals(qStr);
    }

    public String transfer(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = transfer(root.left);
        String right = transfer(root.right);

        String res = left + "," + right + "," + root.val;
        return res;
    }
}
