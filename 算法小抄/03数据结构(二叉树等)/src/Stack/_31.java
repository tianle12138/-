package Stack;
// 31. 下一个排列
//         实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//         如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

import java.util.Arrays;

public class _31 {
    public void nextPermutation(int[] nums) {
        int N = nums.length;

        for (int i = N - 1; i > 0; i--) {
            if(nums[i - 1] < nums[i]) {
                for (int j = N - 1; j > i ; j--) {
                    if(nums[j] > nums[i - 1]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, j, N);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);

    }


}
