package problem_2XX;
// 220. 存在重复元素 III
import java.util.TreeSet;

public class _220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int N = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            Long floor = set.floor((long)nums[i] + (long)t);
            if(floor!= null && floor >= (long)nums[i] - (long)t){
                return true;
            }
            set.add((long)nums[i]);
            while(set.size() == k + 1){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

}
