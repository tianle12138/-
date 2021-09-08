package problem_1XX;

public class _152 {


    public int maxProduct(int[] nums) {
        int N = nums.length;
        int[] sub_max = new int[N + 1];
        int[] sub_min = new int[N + 1];
        sub_max[0] = 1;
        sub_min[0] = 1;

        for (int i = 1; i <= N ; i++) {
            if(nums[i-1] < 0){
                sub_max[i] = Math.max(sub_min[i-1] * nums[i-1],nums[i-1]);
                sub_min[i] = Math.min(sub_max[i-1] * nums[i-1],nums[i-1]);
            } else {
                sub_max[i] = Math.max(sub_max[i-1] * nums[i-1],nums[i-1]);
                sub_min[i] = Math.min(sub_min[i-1] * nums[i-1],nums[i-1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if(max < sub_max[i]){
                max = sub_max[i];
            }
        }
        return max;
    }
}
