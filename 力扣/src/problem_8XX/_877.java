package problem_8XX;

import java.util.HashMap;

public class _877 {

    public static void main(String[] args) {
        _877 clz = new _877();
        int[] piles = new int[]{5, 32, 3, 4,4};
        boolean b = clz.stoneGame_2(piles);
        System.out.println(b);
    }

    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int ans = getMax(piles, 0, piles.length - 1, map);
        return ans > 0;
        // int ans = recurtion(piles, 0, piles.length - 1, solve);
        // return ans > (sum - ans);
    }

    public boolean stoneGame_2(int[] piles) {
        int length = piles.length;
        //从 i.. j中能拿到的最大值
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if((j - i) == 1){
                    dp[i][j] = Math.max(piles[i],piles[j]);
                }else {
                    int select_i = piles[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]);
                    int select_j = piles[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);
                    dp[i][j] = Math.max(select_i,select_j);
                }
            }
        }
        return dp[0][length - 1] > 0;
    }


    private int recurtion(int[] piles, int left, int right, int[][] solve) {
        if (solve[left][right] != 0) return solve[left][right];
        if (left == right) return piles[left];
        if ((right - left) == 1) return Math.max(piles[left], piles[right]);
        int resL = piles[left] + Math.min(recurtion(piles, left + 2, right, solve), recurtion(piles, left + 1, right - 1, solve));
        int resR = piles[right] + Math.min(recurtion(piles, left, right - 2, solve), recurtion(piles, left + 1, right - 1, solve));
        int ans = Math.max(resL, resR);
        solve[left][right] = ans;
        return ans;
    }

    private int getMax(int[] piles, int left, int right, HashMap<String, Integer> solve) {
        String key = left + "," + right;
        if(solve.containsKey(key)) return solve.get(key);
        if (left == right) {
            return piles[left];
        }
        int sLeft = piles[left] - getMax(piles, left + 1, right, solve);
        int sRight = piles[right] - getMax(piles, left, right - 1, solve);
        int ans = Math.max(sLeft, sRight);
        solve.put(key,ans);
        return ans;
    }

}
