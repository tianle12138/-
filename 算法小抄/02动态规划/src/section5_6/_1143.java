package section5_6;
// 1143. 最长公共子序列
public class _1143 {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new _1143().longestCommonSubsequence(text1,text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] table = new int[len1+1][len2+2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    table[i+1][j+1] = table[i][j] + 1;
                } else {
                    table[i+1][j+1] = Math.max(table[i+1][j],table[i][j+1]);
                }
            }
        }
        return table[len1][len2];
    }


}
