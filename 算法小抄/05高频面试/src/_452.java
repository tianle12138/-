import java.util.Arrays;
import java.util.Comparator;

// 452. 用最少数量的箭引爆气球
public class _452 {
    public static void main(String[] args) {
        _452 clazz = new _452();
        int[][] point = {{-2147483646,-2147483645},{2147483646,2147483647}};
        System.out.println(clazz.findMinArrowShots(point));
    }
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //注意，不要直接返回o1[1] - o2[1],会溢出
                if(o1[1] > o2[1]) return 1;
                if(o1[1] < o2[1]) return -1;
                return 0;
            }
        });
        int end = points[0][1];
        int N = 1;
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            if(start <= end){
                continue;
            }
            end = points[i][1];
            N ++;
        }
        return N;
    }
}
