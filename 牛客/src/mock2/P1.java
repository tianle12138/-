package mock2;
import java.util.*;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] attack_money = new int[N][2];
        int[] res = new int[N];

        scanner.nextLine();
        String[] s1 = scanner.nextLine().split(" ");
        for (int i = 0; i < s1.length; i++) {
            attack_money[i][0] = Integer.parseInt(s1[i]);
            map.put(attack_money[i][0], i);
        }
        String[] s2 = scanner.nextLine().split(" ");
        for (int i = 0; i < s2.length; i++) {
            attack_money[i][1] = Integer.parseInt(s2[i]);
        }

        Arrays.sort(attack_money, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) return 1;
                else return -1;
            }
        });
        for (int loop = 0; loop < res.length; loop++) {
            int[] temp = new int[loop];
            for (int i = 0; i < loop; i++) {
                temp[i] = (attack_money[i][1]);
            }
            Arrays.sort(temp);
            int rab = 0;
            int arr_top = temp.length;
            for (int j = 0; j < K; j++) {
                if(arr_top  -- > 0){
                    rab += temp[arr_top];
                }
            }
            res[map.get(attack_money[loop][0])] = attack_money[loop][1] + rab;
        }
        for (int re : res) {
            System.out.print(re + " ");
        }

    }

}

