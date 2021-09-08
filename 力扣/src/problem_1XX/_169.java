package problem_1XX;
//超级水王
public class _169 {
    public int majorityElement(int[] nums) {
        int candNum = nums[0];
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            if(value == 0){
                candNum = nums[i];
                value = 1;
            }else if(nums[i] == candNum){
                value ++;
            }else{
                value --;
            }

        }
        return candNum;
    }
}
