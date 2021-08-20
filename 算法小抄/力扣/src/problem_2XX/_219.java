package problem_2XX;

import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

// 219. 存在重复元素 II
public class _219 {
    //滑动窗口
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> windows = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(windows.contains(nums[i])){
                return true;
            }
            windows.add(nums[i]);
            while(windows.size() == k + 1){
                windows.remove(nums[i - k]);
            }
        }
        return false;
    }


    //超时
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     int N = nums.length;
    //     if (k >= N) {
    //         k = N - 1;
    //     }
    //     for (int i = 0; i < N - k; i++) {
    //         HashSet<Integer> set = new HashSet<>();
    //         set.add(nums[i]);
    //         for (int j = i + 1; j <= i + k; j++) {
    //             if (set.contains(nums[j])) {
    //                 return true;
    //             } else {
    //                 set.add(nums[j]);
    //             }
    //         }
    //     }
    //     return false;
    // }
}
