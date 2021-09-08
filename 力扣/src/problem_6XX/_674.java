package problem_6XX;

import java.util.Arrays;

public class _674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] res =new int[nums.length];
        Arrays.fill(res,1);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                res[i] = 1 + res[i-1];
            }
        }

        int max_len = 0;
        for (int re : res) {
            if(re > max_len){
                max_len = re;
            }
        }
        return max_len;
    }
}
