package mock2;

import java.sql.SQLOutput;
import java.util.*;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();
        int E = in.nextInt();
        if (B == 0) {
            System.out.println(Math.abs(A * C));
        } else {
            if (B * A > 0) {
                if(A < 0) {
                    System.out.println((B - A) * C);
                }else {
                    System.out.println((B - A) * E);
                }
            } else {
                System.out.println((B * E) + D + (0 - A) * C);
            }
        }
    }

}

