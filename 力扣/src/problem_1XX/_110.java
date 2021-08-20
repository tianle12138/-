package problem_1XX;

import domain.TreeNode;
// 110. 平衡二叉树
public class _110 {
    //
    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return height >= 0 ;
    }
    int height(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1 || left < 0 || right < 0){
            return -1;
        }
        return Math.max(left,right) + 1;

    }
    // HashMap<TreeNode,Integer> map = new HashMap<>();
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null) return true;
    //     boolean b1 = isBalanced(root.left);
    //     boolean b2 = isBalanced(root.right);
    //     int l = depth(root.left);
    //     int r = depth(root.right);
    //     boolean cur = false;
    //     if(Math.abs(l - r) <= 1) cur = true;
    //     return cur && b1 && b2;
    // }
    //
    // private int depth(TreeNode root){
    //     if(root == null) return 0;
    //     if(map.containsKey(root)) return map.get(root);
    //     int left = depth(root.left);
    //     int right = depth(root.right);
    //     map.put(root,Math.max(left, right) + 1);
    //     return Math.max(left, right) + 1;
    // }
}
