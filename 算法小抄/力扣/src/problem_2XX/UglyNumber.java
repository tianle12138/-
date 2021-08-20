package problem_2XX;

public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber clazz = new UglyNumber();
        System.out.println(clazz.isUgly(4));
    }

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 5 == 0) {
            n = n / 5;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }
}
