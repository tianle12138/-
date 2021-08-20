package poblem_1XX;


public class _189 {
    public void rotate(int[] nums, int k) {
        int N = nums.length - 1;
        reverse(nums, 0, N - k);
        reverse(nums, N - k + 1, N);
        reverse(nums,0,N);

    }

    void reverse(int[] arr, int l, int r) {
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;r--;
        }
    }

}
