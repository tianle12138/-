public class Jump {
    public static void main(String[] args) {
        Jump clazz = new Jump();
        int[] arr = new int[]{2, 0, 2, 3};
        System.out.println(clazz.canJump(arr));
    }


    public boolean canJump(int[] nums) {
        int N = nums.length;
        int farthest = 0;
        for (int i = 0; i < N - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) return false;
        }
        return farthest >= N - 1;
    }
    // public boolean canJump(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     dp[0] = 1;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (dp[i] == 0) continue;
    //         for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
    //             dp[j] = dp[i] + 1;
    //         }
    //     }
    //     return dp[nums.length - 1] != 0;
    // }
}
