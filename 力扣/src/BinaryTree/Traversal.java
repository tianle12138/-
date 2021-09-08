package BinaryTree;

import domain.TreeNode;

import java.util.*;

public class Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans;
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.offer(root);
        while(!q.isEmpty()){
            int curLevelNums = q.size();
            ans = new ArrayList<>();
            while(curLevelNums -- > 0){
                TreeNode poll = q.poll();
                ans.add(poll.val);
                if(poll.left!= null) {
                    q.offer(poll.left);
                }
                if(poll.right!= null) {
                    q.offer(poll.right);
                }
            }
            res.add(ans);
        }
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            // 先根后左入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null || root.right == prev){
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // if (root != null) stack.push(root);
        while (root != null || !stack.isEmpty()) {
            // 先根后左入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }
        return res;
    }


}
