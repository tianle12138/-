package problem_2XX;

import java.util.zip.CheckedOutputStream;

// 统计所有小于非负整数 n 的质数的数量。
public class _204 {
    public static void main(String[] args) {
        _204 clz = new _204();
        clz.countPrimes(499979);
    }

    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n]; // false代表素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrimes[i]) {
                count++;
                for (int j = i * i; i <= 1500000&& j < n; j += i) {
                    isPrimes[j] = true;
                }
            }
        }
        return count;
    }

}
