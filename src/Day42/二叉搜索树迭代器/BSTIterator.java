package Day42.二叉搜索树迭代器;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    private List<Integer> list = new ArrayList<>();
    private int index = 0;
    public BSTIterator(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode root){
        if (root==null){
            return;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    public int next() {
        Integer integer = list.get(index);
        index++;
        return integer;
    }

    public boolean hasNext() {
        return index!=list.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(20);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        BSTIterator iterator = new BSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());


    }
}
