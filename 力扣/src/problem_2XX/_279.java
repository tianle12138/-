package problem_2XX;
// 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。


public class _279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i*i <=n ; i++) {
                dp[i * i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            if(dp[i] == 0){
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= i; j++) {
                    int ans = 1 + dp[i - j];
                    if(min>ans) {
                        min = ans;
                    }
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
