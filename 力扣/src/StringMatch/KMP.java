package StringMatch;

import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;

public class KMP {

    public static void main(String[] args) {
        String org = "abcabcabcdabd";
        String tar = "abcabcd";
        int index = match(org, tar);
        System.out.println(index);

    }

    static int match(String s1, String s2) {
        int[] next = new int[s2.length()];
        getNext(s2.toCharArray(), next);
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (j == -1 || s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == s2.length()) {
            return i - j;
        } else
            return -1;
    }

    static void getNext(char[] pattern, int[] next) {
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length) {
            if (j == -1|| pattern[i] == pattern[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
    }
}
