import java.util.Scanner;

public class Phase_52 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while( scan.hasNextInt()){
            System.out.println(isOdd(scan.nextInt()));
        }
    }

    private static boolean isOdd(int nextInt) {
        // System.out.println(nextInt % 2);
        // return nextInt % 2 == 1;
        return nextInt % 2 != 0;
    }
}
