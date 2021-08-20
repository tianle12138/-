package section1_2;

import java.util.Arrays;
import java.util.Comparator;

// 354. 俄罗斯套娃信封问题
public class _354 {
    public static void main(String[] args) {
        int [][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(new _354().maxEnvelopes(envelopes));

    }
    // public int maxEnvelopes(int[][] envelopes) {
    //     if(envelopes.length == 0) return 0;
    //     Arrays.sort(envelopes, new Comparator<int[]>() {
    //         @Override
    //         public int compare(int[] o1, int[] o2) {
    //             if(o1[0] > o2[0]) return 1;
    //             else if(o1[0] < o2[0]) return -1;
    //             else {
    //                 if(o1[1] > o2[1]) return -1;
    //                 else if(o1[1] < o2[1]) return 1;
    //             }
    //             return  0;
    //         }
    //     });
    //     // for (int[] envelope : envelopes) {
    //     //     System.out.println( envelope[0] + "  " + envelope[1]);
    //     // }
    //     int[] LIS = new int[envelopes.length];
    //     for (int i = 0; i < envelopes.length; i++) {
    //         LIS[i] = envelopes[i][1];
    //     }
    //
    //     return lengthOfLIS(LIS);
    //
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     Arrays.fill(dp, 1);
    //     for (int i = 0; i < dp.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if(nums[i] > nums[j]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //     }
    //     int MAX_LEN = 1;
    //     for (int i = 0; i < dp.length; i++) {
    //         MAX_LEN = Math.max(MAX_LEN, dp[i]);
    //     }
    //     return MAX_LEN;
    // }

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]) return 1;
                else if(o1[0] < o2[0]) return -1;
                else {
                    if(o1[1] > o2[1]) return -1;
                    else if(o1[1] < o2[1]) return 1;
                }
                return  0;
            }
        });
        // for (int[] envelope : envelopes) {
        //     System.out.println( envelope[0] + "  " + envelope[1]);
        // }
        // int[] LIS = new int[envelopes.length];
        // for (int i = 0; i < envelopes.length; i++) {
        //     LIS[i] = envelopes[i][1];
        // }
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1); // 只让dp[0] = 1是错误的
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
        }

        int MAX_LEN = 1;
        for (int i = 0; i < dp.length; i++) {
            MAX_LEN = Math.max(MAX_LEN, dp[i]);
        }
        return MAX_LEN;

    }
}
