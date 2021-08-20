package section12_13;

import java.util.Arrays;

public class _887 {
    public static void main(String[] args) {
        System.out.println(new _887().superEggDrop2(6,10000));
    }



    public int superEggDrop2(int k, int n) {
        int m = 0;
        int[][] dp = new int[k+1][n+1];
        // while(dp[k][m] < n) {
        //     m++;
        //     for (int kk = 1; kk <= k ; kk++) {
        //         dp[kk][m] = dp[kk][m-1] + dp[kk-1][m-1] + 1;
        //     }
        // }
        for ( m = 0; dp[k][m] < n;) {
            System.out.println("k=" + k + "m" + m + "dp[k][m]" + dp[k][m]);
            m ++;
            for (int kk = 1; kk <= k ; kk++) {
                dp[kk][m] = dp[kk][m-1] + dp[kk-1][m-1] + 1;
            }
        }

        return m;
    }

    // int[][] dp;
    // public int superEggDrop(int k, int n) {
    //     dp = new int[k+1][n+1];
    //     for (int[] ints : dp) {
    //         Arrays.fill(ints, -1);
    //     }
    //     return dp(k,n);
    // }
    //
    // private int dp(int k, int n) {
    //     if(k == 1) return n;
    //     if(n == 0) return 0;
    //     if(dp[k][n] != -1) return dp[k][n];
    //     int res = 100000;
    //     for (int i = 1; i <= n; i++) {
    //         res= Math.min(res, Math.max(dp(k,n-i),dp(k-1,i-1)) + 1);
    //     }
    //     dp[k][n] = res;
    //     return res;
    // }
}
