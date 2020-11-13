package Day21.对称二叉树;

import common.TreeNode;

import java.util.LinkedList;

/**
 * Created by Zhong Mingyi on 2020/11/13.
 * 对称二叉树:
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetricSolution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        IsSymmetricSolution solution = new IsSymmetricSolution();
        System.out.println(solution.isSymmetric(root));
    }

    //递归
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    //迭代
    public boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public boolean check2(TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }
}
