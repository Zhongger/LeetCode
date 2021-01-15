package Day47.分别按照二叉树先序中序和后序打印所有的节点;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ThreeOrdersSolution {
    public int[][] threeOrders(TreeNode root) {
        xianXv(root);
        zhongXv(root);
        houXv(root);
        int[][] res = new int[3][];

        int[] xianxv = new int[xianXvSb.size()];
        for (int i = 0; i < xianxv.length; i++) {
            xianxv[i] = xianXvSb.get(i);
        }
        int[] zhongxv = new int[zhongXvSb.size()];
        for (int i = 0; i < zhongxv.length; i++) {
            zhongxv[i] = zhongXvSb.get(i);
        }
        int[] houxv = new int[houXvSb.size()];
        for (int i = 0; i < houxv.length; i++) {
            houxv[i] = houXvSb.get(i);
        }
        res[0]=xianxv;
        res[1]=zhongxv;
        res[2]=houxv;
        return res;

    }

    private List<Integer> xianXvSb = new ArrayList<>();
    private List<Integer> zhongXvSb = new ArrayList<>();
    private List<Integer> houXvSb = new ArrayList<>();

    public void xianXv(TreeNode root) {
        if (root == null) {
            return;
        }
        xianXvSb.add(root.val);
        xianXv(root.left);
        xianXv(root.right);
    }

    public void zhongXv(TreeNode root) {
        if (root == null) {
            return;
        }
        zhongXv(root.left);
        zhongXvSb.add(root.val);
        zhongXv(root.right);
    }

    public void houXv(TreeNode root) {
        if (root == null) {
            return;
        }
        houXv(root.left);
        houXv(root.right);
        houXvSb.add(root.val);

    }

    public static void main(String[] args) {
        ThreeOrdersSolution solution = new ThreeOrdersSolution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left=node1;
        root.right=node2;
        solution.xianXv(root);
        System.out.println(solution.xianXvSb);

        solution.zhongXv(root);
        System.out.println(solution.zhongXvSb);

        solution.houXv(root);
        System.out.println(solution.houXvSb);
    }
}
