package problem_1XX;

import domain.TreeNode;

// 112. 路径总和
public class _112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int val) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return val == root.val;
        }
        return dfs(root.left, val - root.val) || dfs(root.right, val - root.val);
    }

    // private boolean recursive(TreeNode root, int val, int targetSum) {
    //     if(root.left == null && root.right == null) {
    //         if(val == targetSum) {
    //             return  true;
    //         } else{
    //             return false;
    //         }
    //     }
    //     boolean left = false;
    //     boolean right = false;
    //
    //     if(root.left != null){
    //         left = recursive(root.left, val + root.left.val, targetSum);
    //     }
    //     if(root.right != null){
    //         right = recursive(root.right, val + root.right.val, targetSum);
    //     }
    //     return left || right;
    //
    // }
}
