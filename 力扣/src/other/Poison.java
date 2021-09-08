package other;

import java.util.PriorityQueue;

public class Poison {
    public static void main(String[] args) {
        Poison clz  = new Poison();
        // int ans = clz.maxNums(new int[]{4,-4,1,-3,1,-3});
        int ans = clz.maxWater(new int[]{4,-4,1,-3,1,-3});

        System.out.println(ans);

    }
    //贪心
    // 维护历史喝过的药水并查询毒性最强的药水，即 a i a_i ai​ 最小值，可以用优先队列实现。
    // 假设之前的最优策略为喝下 k k k 瓶药水，那么对于第 i i i 瓶药水：
    // 若能喝第 i i i 瓶药水，则喝下后总数变为 k + 1 k+1 k+1，必然也是最优策略
    // 若不能喝第 i i i 瓶药水，则考虑总数为 k k k 的情况下使得血量尽可能大，即选择之前所有药水中毒性最轻的 k k k 瓶药水喝。这个操作等价考虑用当前药水替代历史喝过的毒性最强的药水。
    public int maxWater(int[] water) {
        int N = water.length;
        PriorityQueue<Integer> minWater = new PriorityQueue<>();
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += water[i];
            minWater.add(water[i]);
            if(S < 0){
                S -= minWater.poll();
            }
        }
        return minWater.size();
    }
    // 设dp{i,j} 表示前 i 个点喝 j 瓶药水的情况下最后生命的最大值。
    public int maxNums(int[] water) {
        int N = water.length;
        int[][] dp = new int[N + 1][N + 1];
        int max_num = 0;
        dp[1][1] = water[0] < 0 ? Integer.MIN_VALUE : water[0];
        if(dp[1][1] >= 0) max_num = 1;
        for (int i = 2; i <= N ; i++) {
            for (int j = 1; j <= i ; j++) {
                int res = Math.max(dp[i - 1][j],dp[i-1][j-1] + water[j - 1]);
                if(res > 0 && j > max_num){max_num = j;}
                dp[i][j] = res < 0 ? Integer.MIN_VALUE : res;
            }
        }
        return max_num;
    }
}
