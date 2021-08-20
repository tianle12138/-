public class SuperPow {

    public static void main(String[] args) {
        SuperPow superPow = new SuperPow();
        int a = 2147483647;
        int []b = {2,0,0};
        System.out.println(superPow.superPow(a,b));
    }


    int base = 1337;
    public int superPow(int a, int[] b) {
        return backtrack(a,b,b.length - 1);
    }

    //计算a的b[0..index]次方对base取模结果
    private int backtrack(int a, int[] b, int index) {
        if(index < 0) return 1;
        int part1 = myPow(a,b[index]);
        int part2 = myPow(backtrack(a,b,index - 1),10);
        return (part1 * part2) % base;
    }

    //改进计算a的k次方对base取模结果
    private int myPow(int a, int k) {
        if(k == 0) return 1;
        a = a % base;
        if(k % 2 == 1){
            return (a * myPow(a,k - 1)) % base;
        }
        int sub = myPow(a, k / 2);
        return (sub * sub) % base;
    }

    // //计算a的k次方对base取模结果
    // private int myPow(int a, int k) {
    //     a = a % base;
    //     int res = 1;
    //     for (int i = 0; i < k; i++) {
    //         res *= a;
    //         res = res % base;
    //     }
    //     return res;
    // }
}
