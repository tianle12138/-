import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return result;
    }

    private void backtrack(int[] nums, int startIndex, List<Integer> track) {
        result.add(new ArrayList<>(track));
        for (int i = startIndex; i < nums.length; i++) {
            //从当前层第二个选择开始，在nums[i .. nums.len]中找到第一个不等于上一个选择的数的索引
            if(i > startIndex) {
                while (i < nums.length && nums[i] == nums[i -1]){
                    i ++;
                }
                if(i == nums.length) break;
            }
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }
}
