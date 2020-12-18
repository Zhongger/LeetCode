package Day30.树的子结构;

import common.TreeNode;

/**
 * Created by Zhong Mingyi on 2020/12/18.
 */
public class IsSubStructureSolution {
    public static void main(String[] args) {

    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B != null) {
            return theSameNode(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        return false;

    }

    public boolean theSameNode(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return theSameNode(A.left, B.left) && theSameNode(A.right, B.right);
    }
}
