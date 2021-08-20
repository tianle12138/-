package Stack;

import java.util.Stack;

public class NGE_II {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] ans = new NGE_II().nextGreaterElements(nums);
        for (int an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }

    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] index = new int[N];
        for (int i = 2 * N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % N] >= stack.peek()) {
                stack.pop();
            }
            index[i % N] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % N]);
        }
        return index;
    }
}
