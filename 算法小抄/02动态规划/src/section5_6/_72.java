package section5_6;

import java.util.ArrayList;
import java.util.Arrays;

// 72. 编辑距离
public class _72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(new _72().minDistance_2(word1,word2));
    }


    /**
     * 动态规划 DP table 法
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] table = new int[len1+1][len2+1];
        //base case
        for (int i = 0; i < len1; i++) {
            table[i][0] = i;
        }
        for (int i = 0; i < len2; i++) {
            table[0][i] = i;
        }

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if(word1.charAt(i) == word2.charAt(j)){
                    table[i + 1][j + 1] = table[i][j];
                }else {
                    table[i + 1][j + 1] = Math.min(table[i][j+1] + 1,Math.min(table[i + 1][j] + 1 , table[i][j] + 1));
                }
            }
        }

        return table[len1][len2];
    }
    /**
     * 回溯法
     * @param word1
     * @param word2
     * @return
     */

    int[][] table ;
    public int minDistance_2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // if(len1 == 0) return len2;
        // if(len2 == 0) return len1;
        table = new int[len1+1][len2+1];
        for (int[] ints : table) {
            Arrays.fill(ints,-1);
        }

       return backtrace(word1,word2,len1-1,len2-1);
    }

    /**
     * word1[0...index1] 和 word2[0...index2]
     * @return
     */

    private int backtrace(String word1, String word2,int index1,int index2) {
        if(index1==-1) return index2 + 1;
        if(index2==-1) return index1 + 1;

        if(table[index1][index2] != -1) return table[index1][index2];
        // System.out.println(index1 + "" + index2);
        if(word1.charAt(index1) == word2.charAt(index2)) {
            return table[index1][index2] = backtrace(word1,word2,index1-1,index2-1);
        } else {
            int res1 = backtrace(word1,word2,index1-1,index2) + 1;
            int res2 = backtrace(word1,word2,index1,index2-1) + 1;
            int res3 = backtrace(word1,word2,index1-1,index2-1) + 1;
            return table[index1][index2] = Math.min(res1,Math.min(res2, res3));
        }
    }

}
