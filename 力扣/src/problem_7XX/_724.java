package problem_7XX;

import java.util.Arrays;

public class _724 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            lSum += nums[i];
            if (i > 0) sum -= nums[i - 1];
            if (lSum == sum) {
                return i;
            }
        }
        return -1;
    }
}
