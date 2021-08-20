package section7_8;

public class _516 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindromeSubseq("bbbab"));
    }
}

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][]dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        //倒着遍历dp数组
        for (int i = len-2; i >=0 ; i--) {
            for (int j = i + 1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                    // dp[i][j] = dp[i+1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }

        return dp[0][len-1];
    }
}
