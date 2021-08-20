
// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return result;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> track) {
        result.add(new ArrayList<>(track));
        for (int i = startIndex; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
