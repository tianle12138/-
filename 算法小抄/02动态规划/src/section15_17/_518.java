package section15_17;


public class _518 {
    public static void main(String[] args) {
        int[]coins = {1, 2, 5};
        int amount = 5;
        System.out.println(new _518().change(amount,coins));
    }

    /**
     * @param amount 需要凑齐多少钱
     * @param coins 有多少面值的硬币
     * @return
     */
    public int change(int amount, int[] coins) {
        //dp[i]当金额为i时有多少组合
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            // for (int j = 0; j <= amount; j++) 也行
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][amount];
    }
    // public int change(int amount, int[] coins) {
    //     //dp[i]当金额为i时有多少组合
    //     int[] dp = new int[amount + 1];
    //     dp[0] = 1;
    //     //循环结束后才能得出答案，每次加入一种新的币种
    //     for (int coin : coins) {
    //         //从当前币面值开始，当前币不能改变金额小于该币的组合
    //         for (int i = coin; i <= amount; i++) {
    //             //dp[i] = 未加入当前币时的组合数 + 加入当前币之后dp[i-coin]的组合数
    //             dp[i] += dp[i - coin];
    //         }
    //     }
    //     return dp[amount];
    // }


    public int change_2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // base case table[0] = 0
        for (int i = 1; i <= amount; i ++) {
            //做选择  当最后一个选了coin时 dp[i-coin]为当前选择的所有排列数
            for (int coin : coins) {
                if(i-coin >= 0){
                    //i-coin 必不相同
                    dp[i] += dp[i-coin];
                }
            }

        }
        return dp[amount];
    }

    //暴力
    // int res = 0;
    // int[] table;
    // public int change(int amount, int[] coins) {
    //     if(amount == 0) return 1;
    //     for (int i = 0; i < coins.length; i++) {
    //         //做选择，只能选择下表为i及其之后的硬币
    //         backtrace(amount-coins[i],coins,i);
    //     }
    //     return res;
    // }
    //
    // private void backtrace(int amount, int[] coins, int index) {
    //     if(amount == 0) {
    //         res ++;
    //         return;
    //     }
    //     if(amount < 0) {
    //         return;
    //     }
    //     for (int i = index; i < coins.length; i++) {
    //         backtrace(amount-coins[i],coins,i);
    //     }
    // }
}
