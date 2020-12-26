package Day37.二叉树的序列化与反序列化;

import common.TreeNode;

import java.util.*;

public class Codec {

    StringBuffer res = new StringBuffer();

    public String serialize(TreeNode root){
        serializeHelper(root);
        return res.toString();

    }

    public void serializeHelper(TreeNode root){
        if (root==null){
            res.append("#").append(",");
            return;
        }
        res.append(root.val).append(",");
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Deque<String> list = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            list.add(nodes[i]);
        }
        return deserializeHelper(list);
    }

    public TreeNode deserializeHelper(Deque<String> list) {
        if (list.isEmpty()){
            return null;
        }
        String first = list.removeFirst();//根节点
        if (first.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left=deserializeHelper(list);
        root.right=deserializeHelper(list);
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        TreeNode rootl = new TreeNode(2);
        TreeNode rootr = new TreeNode(3);
        TreeNode rootrl = new TreeNode(4);
        TreeNode rootrr = new TreeNode(5);

        root.left=rootl;
        root.right=rootr;
        rootr.left=rootrl;
        rootr.right=rootrr;

        System.out.println(codec.serialize(root));
    }
}
