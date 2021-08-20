package queue;

import java.util.ArrayList;
import java.util.LinkedList;

public class MonotonixQueue {

    public static void main(String[] args) {
        MonotonixQueue abd = new MonotonixQueue();
        int[] a = new int[]{1,3,-1,-3,5,3,6,7};
        abd.maxSlidingWindow(a,3);
    }
    //  数据结构部分
    LinkedList<Integer> Q = new LinkedList<>();
    public void push(int n){
        while(!Q.isEmpty() && Q.getLast() < n){
            Q.pollLast();
        }
        Q.addLast(n);
    }
    public int max(){
        return Q.getFirst();
    }
    public void pop(int n) {
        if(Q.getFirst() == n){
            Q.pollFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            if(i < k - 1){
                push(nums[i]);
            }
            else{
                push(nums[i]);
                res.add(max());
                pop(nums[i - k + 1]);
            }
        }
        int[] arr = new int[res.size()];
        int index = 0;
        for (Integer re : res) {
            arr[index++] = re;
        }
        return arr;
    }
}
