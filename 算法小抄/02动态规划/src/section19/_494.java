package section19;
// 494. 目标和
public class _494 {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        System.out.println(new _494().findTargetSumWays(nums, target));
    }
    // 转换为子集背包问题  将nums分为数组A、B，前者全选择“+”，后者全选择“-”
    // 则将问题转换为A，B需要满足A+B =SUM, A-B = target
    // 联合方程有 A = （SUM+target）/2
    //即 在nums中选择和为（SUM+target）/2的所有子集
    //注意，nums中可能有元素为0
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum +=num;
        }
        if((target + sum) % 2 != 0) return 0;
        target = (target + sum) / 2;
        int[][]dp = new int[nums.length + 1][target + 1];
        dp[0][0] = 1;
        // for (int i = 0; i <= nums.length; i++) {
        //     dp[i][0] = 1;
        // }
        for (int i = 1; i <= nums.length; i++) {
            //nums中可能有元素为0，拿和不拿算两种方式，并且都不影响当前的目标容量
            for (int j = 0; j <= target ; j++) {
                if(j < nums[i - 1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
        
    }
    // 回溯法
    // int res = 0;
    // public int findTargetSumWays(int[] nums, int target) {
    //     dp(nums,0,target);
    //     return res;
    // }
    //
    // private void dp(int[] nums, int i, int target) {
    //     if(i == nums.length){
    //         if(target == 0) {
    //             res ++;
    //             return;
    //         } else {
    //             return;
    //         }
    //     }
    //     dp(nums, i + 1, target - nums[i]);
    //     dp(nums, i + 1, target + nums[i]);
    // }
}
