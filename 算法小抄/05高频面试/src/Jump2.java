import java.util.Arrays;

public class Jump2 {

    public static void main(String[] args) {
        Jump2 clazz = new Jump2();
        int[] arr = new int[]{2,3,0,1,4};
        System.out.println(clazz.jump(arr));
    }
    int[] memo;

    //  贪心算法
    public int jump(int[] nums) {
        int N = nums.length;
        int farthest = 0;
        int i_end = 0;
        int steps = 0;
        //i < N-1;我们不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」，因此我们不必访问最后一个元素
        for (int i = 0; i < N - 1; i++) {
            farthest = Math.max(nums[i] + i, farthest);
            if(farthest >= N-1) return steps + 1;
            if(i_end == i){
                steps ++;
                i_end = farthest;
            }
        }
        return steps;
    }


    // public int jump(int[] nums) {
    //     memo = new int[nums.length];
    //     Arrays.fill(memo, nums.length);
    //     return dp(nums, 0);
    // }

    private int dp(int[] nums, int i) {
        if (i >= nums.length - 1) return 0;
        if(memo[i]!=nums.length) return memo[i];
        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + nums[i]; j++) {
            res = Math.min(res, dp(nums, j) + 1);
        }
        memo[i] = res;
        return res;
    }
}
