import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SlidePuzzle {
    public static void main(String[] args) {
        int[][] board = {{1,0,3}, {4, 2, 5}};
        SlidePuzzle clazz = new SlidePuzzle();
        System.out.println(clazz.slidingPuzzle(board));
    }

    //优化 -- >双向搜索
    public int slidingPuzzle(int[][] board) {
        String start = "";
        String target = "123450";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start += board[i][j];
            }
        }
        HashMap<Integer, Integer[]> neighbor = new HashMap<>();
        neighbor.put(0, new Integer[]{1, 3});
        neighbor.put(1, new Integer[]{0, 2, 4});
        neighbor.put(2, new Integer[]{1, 5});
        neighbor.put(3, new Integer[]{0, 4});
        neighbor.put(4, new Integer[]{1, 3, 5});
        neighbor.put(5, new Integer[]{2, 4});

        //用两个集合不用队列，快速判断元素是否存在
        // Queue<String> q = new LinkedList<>();
        HashSet<String> s1 = new HashSet<String>();
        HashSet<String> s2 = new HashSet<String>();
        HashSet<String> visited = new HashSet<String>();
        int step = 0;
        s1.add(start);
        s2.add(target);
        visited.add(start);
        visited.add(target);


        while (!s1.isEmpty() && !s2.isEmpty()) {
            System.out.println("**********************************" + "step = " + step+ "********************************");
            //用于存储s1扩散的结果
            HashSet<String> temp = new HashSet<>();
            for (String cur : s1) {
                System.out.println(cur);

                if (s2.contains(cur)) {
                    return step;
                }
                //
                // visited.add(cur);
                int index_0 = cur.indexOf("0");
                Integer[] pos = neighbor.get(index_0);
                for (Integer p : pos) {
                    String new_board = swap(cur, p, index_0);
                    if (!visited.contains(new_board)) {
                        temp.add(new_board);
                        visited.add(new_board);
                    }
                }
            }
            //交换s1和s2；
            s1 = s2;
            s2 = temp;
            step++;

        }
        return -1;
    }
    //单向搜索
    // public int slidingPuzzle(int[][] board) {
    //     String start = "";
    //     String target = "123450";
    //     for (int i = 0; i < 2; i++) {
    //         for (int j = 0; j < 3; j++) {
    //             start += board[i][j];
    //         }
    //     }
    //     HashMap<Integer, Integer[]> neighbor = new HashMap<>();
    //     neighbor.put(0, new Integer[]{1, 3});
    //     neighbor.put(1, new Integer[]{0, 2, 4});
    //     neighbor.put(2, new Integer[]{1, 5});
    //     neighbor.put(3, new Integer[]{0, 4});
    //     neighbor.put(4, new Integer[]{1, 3, 5});
    //     neighbor.put(5, new Integer[]{2, 4});
    //
    //     Queue<String> q = new LinkedList<>();
    //     HashSet<String> visited = new HashSet<String>();
    //     int step = 0;
    //     q.add(start);
    //     visited.add(start);
    //
    //     while (!q.isEmpty()) {
    //         int size = q.size();
    //         for (int i = 0; i < size; i++) {
    //             String cur = q.poll();
    //             if(target.equals(cur)){
    //                 return step;
    //             }
    //             int index_0 = cur.indexOf("0");
    //             Integer[] pos = neighbor.get(index_0);
    //             for (Integer p : pos) {
    //                 String new_board = swap(cur, p, index_0);
    //                 if(!visited.contains(new_board)){
    //                     q.add(new_board);
    //                     visited.add(new_board);
    //                 }
    //             }
    //         }
    //         step ++;
    //     }
    //     return -1;
    //}


    String swap(String s, int index1, int index2) {
        char[] chars = s.toCharArray();
        char ch = chars[index1];
        chars[index1] = '0';
        chars[index2] = ch;
        return new String(chars);
    }
}
