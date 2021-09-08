package NC;

public class NC105 {
    public int search (int[] nums, int target) {
        if(nums.length == 0) return -1;
      int lo = 0;
      int hi = nums.length - 1;
      while(lo <= hi){
          int mid = lo + (hi - lo) /2;
          if(nums[mid] < target){
              lo = mid + 1;
          } else if(nums[mid] >= target){
              hi = mid - 1;
          }
      }
      if(lo>=nums.length || nums[lo]!=target) {
          return -1;
      }
      return lo;
    }
}
