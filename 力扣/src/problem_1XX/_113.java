package problem_1XX;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _113 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return null;
        ans.add(root.val);
        recursive(root, targetSum, ans);
        return res;
    }

    private void recursive(TreeNode root, int targetSum, ArrayList<Integer> ans) {
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        if(root.left!=null){
            ans.add(root.left.val);
            recursive(root.left,targetSum-root.val,ans);
            ans.remove(ans.size()-1);
        }
        if(root.right!=null){
            ans.add(root.right.val);
            recursive(root.right,targetSum-root.val,ans);
            ans.remove(ans.size()-1);
        }
    }
}
