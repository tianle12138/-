package LCA;
import domain.TreeNode;

import java.util.LinkedList;

import static DeSerializeUtil.Deserilalize.BFS_deSerialize;

public class _BST {

    public static void main(String[] args) {
        Integer[] data = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(5);
        LinkedList<Integer> list = new LinkedList<>();
        for (Integer datum : data) {
            list.add(datum);
        }
        TreeNode root = BFS_deSerialize(list);
        System.out.println(new _BST().lowestCommonAncestor(root,p,q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        // if((p.val - root.val) * (root.val - q.val) >= 0) return root;
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left,p,q);
        } else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right,p,q);
        } else {
            return root;
        }
    }

}
