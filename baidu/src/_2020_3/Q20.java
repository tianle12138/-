package _2020_3;

import java.util.Scanner;

public class Q20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int m = 2;
        int res = 0;
        for (; m <= N; m++) {
            for (int n = m + 1; n <= N; n++) {
                int gy = maxGY(m,n);
                int gb = m * n / gy;
                res = (gb - gy) > res ? (gb - gy) : res;
            }
        }
        System.out.println(res);
    }

    //求最大公约数 m < n
    private static int maxGY(int m, int n) {
        if (m % n == 0) return n;
        return maxGY(n,m%n);
    }
}
