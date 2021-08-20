package section18;

import java.util.Arrays;

// 213. 打家劫舍 II
public class _213 {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(new _213().rob(nums));
    }

    public int rob(int[] nums) {
        int N = nums.length;
        if(nums.length == 0) return 0;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        //case 1 拿第一个房间的,第二个和最后一个房间不能拿
        dp[1] = nums[0];
        for (int i = 2; i <= N; i++) {
            //第2个房间和最后的房间不能拿
            if(i == 2) dp[i] = dp[i - 1];
            else if(i == N) dp[i] = dp[i - 1];
            else {
                dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
            }
        }
        int max = dp[N];

        Arrays.fill(dp, 0);
        //case 2 不拿第一个房价，最后一个房间可拿可不拿
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        max = Math.max(dp[N], max);
        return max;

    }
}
