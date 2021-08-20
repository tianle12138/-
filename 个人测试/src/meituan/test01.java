package meituan;

import java.text.DecimalFormat;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        while(scan.hasNextLine()){
            int M = scan.nextInt();
            int N = scan.nextInt();
            double m = (double) M;
            double res = 0;
            for (int i = 0; i < N; i++) {
                res += m;
                m = Math.sqrt(m);
            }
            System.out.println(df.format(res));

        }
    }
}
