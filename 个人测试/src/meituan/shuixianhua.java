package meituan;

import java.util.Scanner;

public class shuixianhua {
    public static void main(String[] args) {
        int[] res = new int[]{153,370,371,407};
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            boolean flag = false;
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            for (int re : res) {
                if(m <= re && n >= re){
                    if(flag) System.out.print(" "+re);
                    else {
                        flag = true;
                        System.out.print(re);
                    }
                }
            }
            if(!flag) System.out.print("no");
            System.out.println();
        }
        for (int i = 100; i <= 999 ; i++) {
            if(valid(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static boolean valid(int i) {
        int t = i;
        int sum = 0;
        while(t > 0){
            sum += (t % 10) * (t % 10) * (t % 10);
            t = t / 10;
        }
        if(sum == i)return true;
        return false;
    }
}
