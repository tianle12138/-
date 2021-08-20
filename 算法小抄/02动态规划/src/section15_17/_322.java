package section15_17;
// 322. 零钱兑换
//
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
// 如果没有任何一种硬币组合能组成总金额，返回 -1。
public class _322 {

    public static void main(String[] args) {
        int[]coins = {2};
        int amount = 0;
        System.out.println(new _322().coinChange(coins, amount));
    }
    //  动态规划法  table[i]表示当容量为i时最少的硬币组合数
    public int coinChange(int[] coins, int amount) {
       int[] table = new int[amount + 1];
       // base case table[0] = 0
        for (int i = 1; i <= amount; i ++) {
            int res = 10000;
            for (int coin : coins) {
                //当背包有空间时，做选择
                if(i-coin >= 0)
                    res = Math.min(res,table[i-coin]);
            }
            table[i] = res == 10000 ? 10000:res+1;
        }
        return table[amount] == 10000?-1:table[amount];
    }

    //  回溯法
    // int[] table;
    // public int coinChange(int[] coins, int amount) {
    //     table = new int[amount + 1];
    //     int res = backtrace(coins,amount);
    //     return res == 10000 ? -1:res;
    // }
    //
    // private int backtrace(int[] coins, int amount) {
    //     if(amount == 0) return 0;
    //     if(table[amount] != 0) return table[amount];
    //     int res = 10000;
    //     for (int coin : coins) {
    //         if((amount - coin) < 0) continue;
    //         else{
    //             res = Math.min(res,backtrace(coins, amount - coin) + 1);
    //         }
    //     }
    //     table[amount] = res;
    //     return res;
    // }

}
