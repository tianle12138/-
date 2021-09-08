package mock2;

import java.util.*;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int a = in.nextInt();
        int k = (r - l) / a;
        int count = 0;

        for (int i = 1; i <= k; i++) {
            count += (r - l) - i * a + 1;
        }

        // for (int i = l; i <r ; i++) {
        //     count += (r - i) / a;
        // }
        System.out.println(count);
    }

}

