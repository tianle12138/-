package problem_4XX;

import java.awt.font.NumericShaper;
import java.util.Stack;

public class _415 {
    public String addStrings(String num1, String num2) {
        int i1, i2;
        i1 = num1.length() - 1;
        i2 = num2.length() - 1;
        int sign = 0;
        StringBuffer res = new StringBuffer();
        while (i1 >= 0 || i2 >= 0) {
            int v1 = i1 < 0 ? 0 : num1.charAt(i1) - '0';
            int v2 = i2 < 0 ? 0 : num2.charAt(i2) - '0';
            int add = v1 + v2 + sign;
            sign = add / 10;
            add = add % 10;
            res.append(add);
            i1--;
            i2--;
        }
        if (sign == 1) {
           res.append(sign);
        }
        return res.reverse().toString();

    }
    // public String addStrings(String num1, String num2) {
    //     Stack<Character> res = new Stack<>();
    //     Stack<Character> n1 = new Stack<>();
    //     Stack<Character> n2 = new Stack<>();
    //     for (char c : num1.toCharArray()) {
    //         n1.push(c);
    //     }
    //     for (char c : num2.toCharArray()) {
    //         n2.push(c);
    //     }
    //     int sign = 0;
    //     while (!n1.isEmpty() && !n2.isEmpty()) {
    //         int val = n1.pop() + n2.pop() - 2 * '0' + sign;
    //         sign = val / 10;
    //         val = val % 10;
    //         res.push((char) ('0'+val));
    //     }
    //     while(!n1.isEmpty()){
    //         int val = n1.pop() - '0' + sign;
    //         sign = val / 10;
    //         val = val % 10;
    //         res.push((char) ('0'+val));
    //     }
    //     while(!n2.isEmpty()){
    //         int val = n2.pop() - '0' + sign;
    //         sign = val / 10;
    //         val = val % 10;
    //         res.push((char) ('0'+val));
    //     }
    //     if(sign == 1){
    //         res.push('1');
    //     }
    //     char[] chs = new char[res.size()];
    //     for (int i = 0; !res.isEmpty(); i++) {
    //         chs[i] = res.pop();
    //     }
    //     return new String(chs);
    // }
}
