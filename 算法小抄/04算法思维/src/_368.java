// 368. 最大整除子集

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class _368 {


    public static void main(String[] args) {
        _368 cla = new _368();
        cla.largestDivisibleSubset(new int[]{2,3,4,8,9});
    }
    List<Integer> result = new ArrayList<>();
    int max_len = 0;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        backtrack(nums, 0, ans);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> ans) {

        if (ans.size() > max_len) {
            max_len = ans.size();
            result = new ArrayList<>(ans);
        }

        for (int i = index; i < nums.length; i++) {
            boolean select = true;
            for (Integer an : ans) {
                if (nums[i] % an != 0) {
                    select = false;
                    break;
                }
            }
            //做选择
            if (select) {
                ans.add(nums[i]);
                backtrack(nums, i + 1, ans);
                //撤销选择
                ans.remove(ans.size() - 1);
            }
        }
    }
}
