package problem_0XX;

public class _033 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int min_index = getMin(nums);
        if (target >= nums[0]) {
            return BS(nums, target, 0, min_index - 1);
        } else {
            return BS(nums, target, min_index, r);
        }

        // while (l < r) {
        //     int mid = l + (r - l) / 2;
        //     if (nums[mid] == target) return mid;
        //     if (nums[l] < nums[mid]) {
        //         if (target >= nums[l] && target <= nums[mid]) {
        //             r = mid;
        //         } else {
        //             l = mid + 1;
        //         }
        //     } else{
        //         if (target >= nums[mid + 1] && target <= nums[r]) {
        //             l = mid + 1;
        //         } else {
        //             r = mid;
        //         }
        //     }
        // }
    }

    private int BS(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private int getMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
