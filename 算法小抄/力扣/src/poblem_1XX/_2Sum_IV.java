package poblem_1XX;


import domain.TreeNode;

import java.util.HashSet;

public class _2Sum_IV {
    HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        for (Integer integer : set) {
            if(set.contains(k - integer) && (2*integer!=k)){
                return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode root) {
        if(root == null){return;}
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
