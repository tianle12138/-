package problem_5XX;

import java.util.HashMap;

public class _560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - k)) {
                ans += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
