package problem_10XX;

import java.util.Arrays;

public class _1099 {
    class Solution {
        public int twoSumLessThanK(int[] nums, int k) {
            int max = -1;
            Arrays.sort(nums);
            int i = 0; int j = nums.length - 1;
            while(i < j) {
                if(nums[i] + nums[j] >= k){
                    j --;
                }else  {
                    if(nums[i] + nums[j] > max) {
                        max = nums[i] + nums[j];
                    }
                    i ++;
                }
            }
            return max;
        }
    }
}
