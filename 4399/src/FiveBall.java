import java.util.ArrayList;

public class FiveBall {

    static int sum = 0;
    public static void main(String[] args) {
        int[] combine = new int[5];

        backtrace(combine, 0);
        System.out.println(sum);
    }

    private static void backtrace(int[] combine, int pos) {
        if(pos == 5){
            check(combine);
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (isValid(combine, pos, i)) {
                combine[pos] = i;
                backtrace(combine, pos + 1);
            }

        }
    }

    private static boolean check(int[] combine) {
        for (int i = 0; i < 5; i++) {
            if(combine[i] == i + 1) return false;
        }
        sum ++;
        return true;
    }

    private static boolean isValid(int[] combine, int pos, int i) {
        for (int j = 0; j < pos; j++) {
            if(combine[j] == i) return false;
        }
        return true;
    }
}
