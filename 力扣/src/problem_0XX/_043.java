package problem_0XX;

// 43. 字符串相乘
public class _043 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        //因为m*n最少是m+n-1位数，最多为m+n位数
        int start = res[0] == 0 ? 1:0;
        for (int i = start; i < res.length; i++) {
            result.append(res[i]);
        }
        return result.toString();
    }




    public String multiply_2(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        if ("1".equals(num1)) return num2;
        if ("1".equals(num2)) return num1;
        int padding = 0;
        String ans = "";
        for (int i = num2.length() - 1; i >= 0;  padding++,i--) {
            String mul = multi(num1, num2.charAt(i));
            if (mul.length() == 0) {

                continue;
            }
            for (int j = 0; j < padding; j++) {
                mul = mul + "0";
            }
            ans = addition(ans, mul);


        }
        return ans;
    }

    private String addition(String s, String mul) {
        if (s.length() == 0) return mul;
        String res = "";
        int i0 = s.length() - 1;
        int i1 = mul.length() - 1;
        int sign = 0;
        while (i0 >= 0 || i1 >= 0) {
            int v0 = i0 >= 0 ? s.charAt(i0) - '0' : 0;
            int v1 = i1 >= 0 ? mul.charAt(i1) - '0' : 0;
            int ans = v0 + v1 + sign;
            res = ans%10 + res;
            sign = ans / 10;
            i0--;i1--;
        }
        if(sign==1){
            res = "1" + res;
        }
        return res;
    }

    private String multi(String num1, char charAt) {
        String ans = "";
        int factor = charAt - '0';
        if (factor == 0) return ans;
        if (factor == 1) return num1;
        int sign = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int val = num1.charAt(i) - '0';
            int res = val * factor + sign;
            ans = (res % 10) + ans;
            sign = res / 10;
        }
        if (sign != 0) {
            ans = sign + ans;
        }
        return ans;
    }


}
