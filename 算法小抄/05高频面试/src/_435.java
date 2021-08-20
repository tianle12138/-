import java.util.Arrays;
import java.util.Comparator;

// 435. 无重叠区间
public class _435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int selected = 1;
        int end = intervals[0][1];
        for (int[] interval : intervals) {
           if(interval[0] < end) {
               continue;
           }
           end = interval[1];
           selected ++;
        }
        return intervals.length -selected;


    }
}
