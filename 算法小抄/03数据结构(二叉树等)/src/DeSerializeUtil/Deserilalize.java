package DeSerializeUtil;

import domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Deserilalize {
    //前序遍历结果字符串反序列化为二叉树
    public static TreeNode Preorder_deSerialize(LinkedList<Integer> nodes) {
        if (nodes.isEmpty()) return null;
        Integer first = nodes.removeFirst();
        if (first == null) return null;
        TreeNode cur = new TreeNode(first);
        cur.left = Preorder_deSerialize(nodes);
        cur.right = Preorder_deSerialize(nodes);
        return cur;
    }

    //层序遍历结果字符串反序列化为二叉树
    public static TreeNode BFS_deSerialize(LinkedList<Integer> nodes) {
        if (nodes.isEmpty()) return null;
        Integer first = nodes.removeFirst();
        if (first == null) return null;
        TreeNode root = new TreeNode(first);
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!nodes.isEmpty()){
            TreeNode cur = q.poll();
            Integer left_val = nodes.removeFirst();

            if(left_val != null){
                TreeNode left = new TreeNode(left_val);
                q.offer(left);
                cur.left = left;
            } else {
                cur.left = null;
            }

            Integer right_val = nodes.removeFirst();
            if(right_val != null){
                TreeNode right = new TreeNode(right_val);
                q.offer(right);
                cur.right = right;
            } else {
                cur.right = null;
            }

        }
        return root;
    }
}
