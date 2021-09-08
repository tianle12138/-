package other;

// 25-删除m位数是剩下的最大
// 请在整数 n 中删除m个数字, 使得余下的数字按原次序组成的新数最大，
//         比如当n=92081346718538，m=10时，则新的最大数是9888
public class MaxNum {
    public static void main(String[] args) {
        String str = "542371";
        int len = str.length();
        int deleteN = 2;
        int times = len - deleteN;
        char[] chars = str.toCharArray();
        int[] sign = new int[len];
        for (int i = 0; i < times; i++) {
            int j = len - times + i;
            int max_pos = j;
            for (j --; j >= 0 ; j --) {
                if(sign[j] != 1 && chars[j] >= chars[max_pos]){
                    max_pos = j;
                }
            }
            sign[max_pos] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if(sign[i] == 1){
                sb.append(chars[i]);
            }
        }
        System.out.println(sb);

    }
}
