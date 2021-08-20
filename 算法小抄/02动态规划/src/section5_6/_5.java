package section5_6;

import java.util.HashSet;
import java.util.Set;

public class _5 {

    public static void main(String[] args) {
        System.out.println(new _5().longestPalindrome("a"));
        System.out.println(new _5().is_palindrome("a"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int max_len = 0;
        for (int i = 0; i < len; i++) {
           for(int j = i + 1;j <= len;j ++){
               if((j - i) > max_len  && is_palindrome(s.substring(i,j))){
                   left = i;
                   right = j;
                   max_len = (j - i);
               }
           }
        }

        return s.substring(left,right);
    }

    private boolean is_palindrome(String sub) {
        int len = sub.length();
        if(len == 0) return false;
        int left = 0;
        int right = len - 1;
        while (left < right){
            if(sub.charAt(left) != sub.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }
}
