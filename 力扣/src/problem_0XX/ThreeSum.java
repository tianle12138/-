package problem_0XX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum cls = new ThreeSum();
        cls.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 2; first++) {
            twoSum(nums, first);
            //跳过第一个数字重复的情况，否则会出现重复的结果
            while (first < nums.length -1 && nums[first] == nums[first + 1]) first ++;
        }
        return res;
    }

    private void twoSum(int[] nums, int first) {
        int tar = -nums[first];
        int left = first + 1;
        int right = nums.length-1;
        while(left < right){
            int left_val = nums[left];
            int right_val = nums[right];
            int sum = nums[left] + nums[right];
            if(sum < tar){
                left ++;
            } else if(sum > tar){
                right --;
            } else{
                ArrayList<Integer> t = new ArrayList<>(Arrays.asList(nums[first],nums[left],nums[right]));
                res.add(t);
                while(left < right  && nums[left] == left_val) left++;
                while(left < right && nums[right] == right_val) right--;
            }
        }

    }

}
