import java.util.Scanner;
import java.util.TreeSet;

public class mokao1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        while(N-- > 0){
            set.add(scanner.nextInt());
        }
        while(set.size() > 1){
            Integer first = set.first();
            set.remove(first);
            if(first > Integer.MAX_VALUE / 2){
                System.out.println("NO");
                return;
            }
            if(!set.contains(first*2))
                set.add(first*2);
        }
        // System.out.println(set.first());
        System.out.println("YES");
        return;
    }
}
