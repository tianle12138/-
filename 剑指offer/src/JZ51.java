public class JZ51 {
    public static void main(String[] args) {
        int[] nums = new int[]{7,5,6,4};
        JZ51 clz = new JZ51();
        clz.reversePairs(nums);
        System.out.println(count);
    }


    static int count = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return count;
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left == right) return;
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
                count += (mid - start1 + 1);//只需要这行代码
                temp[cur++] = nums[start2++];
            }
        }
        while(start1<=mid){
            temp[cur++] = nums[start1++];
        }
        while(start2<=right){
            temp[cur++] = nums[start2++];
        }
        while(left<=right){
            nums[left] = temp[left];
            left++;
        }

    }
}
