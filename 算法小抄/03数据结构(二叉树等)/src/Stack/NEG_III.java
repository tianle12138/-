package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 556. 下一个更大元素 III
public class NEG_III {
    public static void main(String[] args) {
        NEG_III clazz = new NEG_III();
        System.out.println( clazz.nextGreaterElement(12));

        // for (int an : ints) {
        //     System.out.print(an + " ");
        // }
        // System.out.println();
     }

    // 1、先把字符串转成数字数组，如：[1, 3, 5, 4, 1]
    // 2、从后往前找，找到第一个下降的位置，记为 k。 在样例中就是找到 3
    // 3、重新从后往前找，找到比 k 要大的数。 在样例中就是找到 4
    // 4、将两者交换。
    // 5、因为已经把大数放在k位置上了，所以直接将 k 以后的部分变为升序。
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] array = s.toCharArray();

        int len = s.length();
        for (int i = len - 1; i > 0; i--) {
            // 2、从后往前找，找到第一个下降的位置，记为 k。
            if (array[i - 1] < array[i]) {
                // 3、重新从后往前找，找到比 k 要大的数。 在样例中就是找到 4
                for (int j = len - 1; j > i - 1; j--) {
                    if (array[j] > array[i - 1]) {
                        swap(array, i - 1, j);
                        Arrays.sort(array, i, len);
                        String res = new String(array);

                        long ans = Long.parseLong(res);
                        if (ans > Integer.MAX_VALUE){
                            return -1;
                        }

                        return (int)ans;
                    }
                }
            }
        }
        return -1;
    }
    public void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }




    //
    // public int nextGreaterElement(int n) {
    //     int nest = -1;
    //     int pos = -1;
    //     ArrayList<Integer> list = new ArrayList<>();;
    //     int[] ints = parseInt(n);
    //     int i;
    //     for ( i = ints.length - 1; i >= 0 ; i --) {
    //         int j;
    //         for (j = i - 1; j >= 0 ; j --) {
    //             if(ints[j] < ints[i]){
    //                 if(nest < j){
    //                     nest = j;
    //                     pos = i;
    //                 }
    //                 break;
    //             }
    //         }
    //         if(nest >= i){
    //             //从右往左 找到索引最大的nums[nest]比nums[nest]小的数
    //             // for (int k = j; k < ints.length; k++) {
    //             //     if(k != i){
    //             //         list.add(ints[k]);
    //             //     }
    //             // }
    //             int temp = ints[nest];
    //             ints[nest] = ints[pos];
    //             ints[pos] = temp;
    //             Arrays.sort(ints,nest + 1,ints.length);
    //             break;
    //         }
    //     }
    //
    //     // for (int an : ints) {
    //     //     System.out.print(an + " ");
    //     // }
    //     // System.out.println();
    //
    //     if(nest == -1) return -1;
    //     return deParseints(ints);
    // }
    //
    // private int deParseints(int[] ints) {
    //     long res = 0;
    //     for (int i = ints.length - 1; i >= 0; i--) {
    //         res += (long)ints[i] * Math.pow(10,ints.length - i - 1);
    //     }
    //     return (res > Integer.MAX_VALUE) ? -1 : (int) res;
    //
    // }
    //
    // private int[] parseInt(int n) {
    //     Stack<Integer> stack = new Stack<>();
    //     while (n != 0) {
    //         stack.push(n % 10);
    //         n /= 10;
    //     }
    //     int[] res = new int[stack.size()];
    //     int index = 0;
    //     while (!stack.isEmpty()) {
    //         res[index++] = stack.pop();
    //     }
    //     return res;
    // }
}
