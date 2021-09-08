package problem_2XX;

public class _283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        for (; fast < n; fast++) {

            if(nums[fast] != 0){
                swap(nums,slow,fast);
                slow++;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        if(left == right) return;
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
