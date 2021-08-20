package problem_2XX;

import java.util.HashSet;

// 寻找重复数
public class _287 {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return num;
            } else {
                set.add(num);
            }
        }
        return 0;
    }
}
