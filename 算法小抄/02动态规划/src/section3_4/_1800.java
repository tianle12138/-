package section3_4;
// 1800. 最大升序子数组和
public class _1800 {

    public static void main(String[] args) {
        int[] nums = {10,20,30,40,50};
        System.out.println(new _1800().maxAscendingSum(nums));
    }

    public int maxAscendingSum(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]){
                dp[i] = nums[i] + dp[i - 1];
            }
        }
        int max = 1;
        for (int num : dp) {
            max = Math.max(num, max);
        }
        return max;
    }

}
