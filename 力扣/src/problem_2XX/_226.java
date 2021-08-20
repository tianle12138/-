package problem_2XX;

import domain.TreeNode;

import java.util.TreeMap;

public class _226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
