import java.util.ArrayList;
import java.util.Arrays;

public class CountPrime {
    public static void main(String[] args) {
        System.out.println(new CountPrime().countPrimes(5000000));
    }

    //筛数法
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n ; i++) {
            if(isPrime[i]){
                for (int j = 2 * i; j < n ; j+=i) {
                    isPrime[j] = false;
                }
            }

        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    // public int countPrimes(int n) {
    //     int count = 0;
    //     for (int i = 2; i <= n; i++) {
    //         if (is_prime(i)) count++;
    //     }
    //     return count;
    // }
    //
    // private boolean is_prime(int n) {
    //     if (n <= 1) return false;
    //     for (int i = 2; i * i <= n; i++) {
    //         if (n % i == 0) return false;
    //     }
    //     return true;
    // }
}
