package Day51;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] array2 = {0, 1, 2, 3, 4, -1, -1, -1, 8, 9};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(array);
        solution.print(root);
        System.out.println();
        solution.printByStack(root);
        System.out.println();
        TreeNode root2 = solution.buildTree(array2);
        solution.print(root2);
        System.out.println();
        solution.printByStack(root2);
    }

    public void printByStack(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();//存放结果
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.poll();
            list.add(root.val);
            root=root.right;

        }
        System.out.println(list);
    }

    public void print(TreeNode root){
        if (root==null){
            return;
        }
        print(root.left);
        System.out.print(root.val+" ");
        print(root.right);
    }

    public TreeNode buildTree(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            TreeNode treeNode = new TreeNode(array[i]);//存放-1
            list.add(treeNode);
        }
        for (int i = 0; i < list.size() / 2-1; i++) {
            if (list.get(i).val == -1) {
                continue;
            }
            TreeNode treeNode = list.get(i);
            if (list.get(2*i+1).val!=-1){
                treeNode.left = list.get(i * 2 + 1);
            }
            if (list.get(2*i+2).val!=-1){
                treeNode.right = list.get(2 * i + 2);
            }

        }
        int index = array.length / 2-1;
        TreeNode treeNode = list.get(index * 2 + 1);
        list.get(index).left=treeNode;
        if (array.length%2==1){
            list.get(index).right=list.get(index*2+2);
        }
        return list.get(0);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
