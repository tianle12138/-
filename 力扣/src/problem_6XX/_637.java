package problem_6XX;
// 637. 二叉树的层平均值

import domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637 {

    ArrayList<Double> res;
    public List<Double> averageOfLevels(TreeNode root) {
        res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        double cur_sum;
        double cur_nums;
        q.add(root);
        while (!q.isEmpty()){
            cur_sum = 0.0;
            cur_nums = q.size();
            for (int i = 0; i < cur_nums; i++) {
                TreeNode cur = q.poll();
                cur_sum += cur.val;
                if(cur.left!= null) q.offer(cur.left);
                if(cur.right!= null) q.offer(cur.right);
            }
            res.add(cur_sum / cur_nums);
        }

        return res;
    }
}
