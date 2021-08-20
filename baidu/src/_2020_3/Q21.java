package _2020_3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q21 {
    public static void main(String[] args) {
        PriorityQueue<Long> queue = new PriorityQueue<Long>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o1 > o2) return -1;
                else return 1;
            }
        });
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int n = N;
        while(N -- > 0){
            queue.offer(scan.nextLong());
        }
        Long peek;
        int k = 0;
        while ((peek = queue.poll()) >= n){
            for (Long l : queue) {
                l = l + 1;
            }
            queue.offer(peek - n);
            k++;
        }
        System.out.println(k);
    }
}
