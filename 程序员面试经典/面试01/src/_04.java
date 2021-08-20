import java.util.HashSet;
import java.util.Set;

public class _04 {
    public static void main(String[] args) {
        String s = "tactcoa";
        System.out.println(new Solution().canPermutePalindrome(s));
    }
}


class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for (char c : chars) {
            if(set.contains(c)){
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if(set.size() ==0 || set.size() == 1) return true;
        return false;
    }
}