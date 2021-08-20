package Stack;

import java.util.Stack;

public class Weather {
    public static void main(String[] args) {
        int[] nums = {73,74,75,71,69,72,76,73};
        int[] ans = new Weather().nextWarmDay(nums);
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }
    public int[] nextWarmDay(int[] nums){
        int[] index = new int[nums.length];
        Stack<Integer> stack = new Stack<>();//存储nums数组元素对应的下标
        for (int i = nums.length - 1; i >= 0 ; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            index[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return index;
    }
}
