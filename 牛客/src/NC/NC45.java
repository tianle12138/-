package NC;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NC45 {

    List<Integer> res1 = new ArrayList<>();
    List<Integer> res2 = new ArrayList<>();
    List<Integer> res3 = new ArrayList<>();
    public int[][] threeOrders (TreeNode root) {
        preOrder(root);
        inOrder(root);
        postOrder(root);
        // write code here
        int[][] res = new int[3][res1.size()];

        res[0] = convert(res1);
        res[1] = convert(res2);
        res[2] = convert(res3);

        return res;
    }

    private void postOrder(TreeNode root) {
        if(root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        res3.add(root.val);
    }

    private void inOrder(TreeNode root) {
        if(root==null)return;
        inOrder(root.left);
        res2.add(root.val);
        inOrder(root.right);
    }

    private void preOrder(TreeNode root) {
        if(root==null)return;
        res1.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private int[] convert(List<Integer> list){
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }

        return arr;
    }

}
