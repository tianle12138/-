public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9,5,4,7,8,1,2,3,6,0};
        MergeSort clz = new MergeSort();
        clz.mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private void mergeSort(int[] nums) {
        if (nums.length == 0) return;
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = (right + left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merger(nums, left, mid, right, temp);
    }

    private void merger(int[] nums, int left, int mid, int right, int[] temp) {
        int start1 = left;
        int start2 = mid + 1;
        int cur = left;
        while (start1 <= mid && start2 <= right) {
            if (nums[start1] <= nums[start2]) {
                temp[cur++] = nums[start1++];
            } else{
                temp[cur++] = nums[start2++];
            }
        }
        while(start1<=mid){
            temp[cur++] = nums[start1++];
        }
        while(start2<=right){
            temp[cur++] = nums[start2++];
        }
        {

        }
        while(left<=right){
            nums[left] = temp[left];
            left++;
        }

    }


}
