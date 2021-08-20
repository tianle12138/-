public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome clazz = new LongestPalindrome();
        String res = clazz.longestPalindrome("ac");
        System.out.println(res);
    }


    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            if (res.length() < s1.length()) {
                res = s1;
            }
            if (res.length() < s2.length()) {
                res = s2;
            }

        }
        return res;
    }

    String palindrome(String str, int l, int r) {
        while (l >= 0 && r < str.length()) {
            if (str.charAt(l) == str.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return str.substring(l + 1, r);
    }

}
