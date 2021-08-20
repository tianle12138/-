package section18;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.HashMap;

// 337. 打家劫舍 III
public class _337 {
    HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        //选择当前节点
        int select = root.val + (root.left == null ? 0:rob(root.left.left) + rob(root.left.right))
                    + (root.right == null ? 0:rob(root.right.left) + rob(root.right.right));
        //不选择当前节点
        int no_select = (root.left == null ? 0:rob(root.left))
                + (root.right == null ? 0:rob(root.right));
        int res = Math.max(select, no_select);
        map.put(root,res);
        return res;

    }
}
