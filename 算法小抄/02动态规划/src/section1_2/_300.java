package section1_2;

import java.util.Arrays;

// 最长递增子序列
public class _300 {

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        new _300().lengthOfLIS(nums);
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }
}
