package problem_1XX;

import java.lang.annotation.ElementType;

public class _2Sum_II {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] < target){
                left ++;
            } else{
                right --;
            }
        }
        return new int[]{0,0};
    }
}
