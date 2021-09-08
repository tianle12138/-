package problem_2XX;

import java.util.PriorityQueue;

// 215. 数组中的第K个最大元素
public class _215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.offer(num);
            if(q.size()>k){
                q.poll();
            }
        }
        return  q.poll();

    }
}
