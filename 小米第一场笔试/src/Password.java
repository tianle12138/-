import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] passwd = new int[N];
        int[][] ops = new int[M][2];
        for (int i = 0; i < M; i++) {
            ops[i][0] = scan.nextInt();
            ops[i][1] = scan.nextInt();
        }

        for (int i = M - 1; i >= 0; i--) {
            int l = ops[i][0];
            int r = ops[i][1];
            for (int j = l; j <= r; j++) {
                if (passwd[j] == 0) {
                    passwd[j] = i+1;
                }
                continue;
            }
        }
        long res = 0;
        for (int i = 0; i < passwd.length; i++) {
            long temp = (long) i * passwd[i];
            res = res + temp;
        }
        System.out.println((int) (res % 100000009));
    }




}
