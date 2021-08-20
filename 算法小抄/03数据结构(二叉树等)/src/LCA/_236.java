package LCA;
// 二叉树的最近公共祖先
import domain.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

import static DeSerializeUtil.Deserilalize.BFS_deSerialize;

public class _236 {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode p = new TreeNode(7);
        TreeNode q = new TreeNode(4);
        LinkedList<Integer> list = new LinkedList<>();
        for (Integer datum : data) {
            list.add(datum);
        }
        TreeNode root = BFS_deSerialize(list);
        System.out.println(new _236().lowestCommonAncestor(root,p,q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!= null && right != null) {
            return root;
        }
        else if(left == null && right == null) {
            return null;
        }
        else{
            return left!=null ? left : right;
        }
    }


}
