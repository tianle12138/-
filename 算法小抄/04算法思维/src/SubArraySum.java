import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
        SubArraySum clazz = new SubArraySum();
        int[] arr = new int[]{1,1,1};
        int i = clazz.subarraySum(arr, 2);
        System.out.println(i);
    }

    //使用HashMap优化双循环
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
      HashMap<Integer,Integer> subArraySum = new HashMap<>();
      //base case
        subArraySum.put(0,1);
        int sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            int target = sum0_i - k;
            if(subArraySum.containsKey(target)){
                ans += subArraySum.get(target);
            }
            subArraySum.put(sum0_i,subArraySum.getOrDefault(sum0_i,0) + 1);
        }
        return ans;
    }

    // public int subarraySum(int[] nums, int k) {
    //     int n = nums.length;
    //     //sumArray[i] 为 nums[0..i-1]的和;
    //     int[] sumArray = new int[n + 1];
    //     sumArray[0] = 0;
    //     int ans = 0;
    //     for (int i = 0; i < n; i++) {
    //         sumArray[i + 1] = sumArray[i] + nums[i];
    //     }
    //     for (int i = 1; i <= n; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if(sumArray[i] - sumArray[j] == k){
    //                 ans ++;
    //             }
    //         }
    //     }
    //     return ans;
    // }
}
