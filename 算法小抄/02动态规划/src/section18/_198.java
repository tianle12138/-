package section18;
// 198. 打家劫舍
public class _198 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(new _198().rob(nums));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        // 子问题：
        // f(k) = 偷 [0..k) 房间中的最大金额 房间编号从1开始
        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            //nums[i - 1]表示第i个房间的钱
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[n];
    }

    // public int rob(int[] nums) {
    //     dp = new int[nums.length];
    //     return dp(nums, 0);
    // }

    //递归 最后一个样例超时
    // int[] dp;
    // public int rob(int[] nums) {
    //     dp = new int[nums.length];
    //     return dp(nums, 0);
    // }
    //
    // private int dp(int[] nums, int i) {
    //     if(i >= nums.length) return 0;
    //     if(dp[i] != 0) return dp[i];
    //     int res = Math.max(dp(nums, i + 1), nums[i] + dp(nums, i + 2));
    //     dp[i] = res;
    //     return res;
    // }


}
