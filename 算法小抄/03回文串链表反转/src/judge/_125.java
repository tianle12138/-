package judge;
// 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

public class _125 {
    public static void main(String[] args) {
        _125 clazz = new _125();
        boolean palindrome = clazz.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        char[] chars = s1.toCharArray();
        int index = 0;
        for (char aChar : chars) {
            if((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z')){
                chars[index++] = aChar;
            }
        }
        String post = new String(chars, 0, index);
        System.out.println(post);
        return judge(post);
    }

    private boolean judge(String post) {
        int l = 0;
        int r = post.length() - 1;
        while (l < r) {
            if(post.charAt(l) != post.charAt(r)){
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }

}
