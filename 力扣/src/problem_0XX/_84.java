package problem_0XX;

import java.util.ArrayDeque;
import java.util.Deque;

// 84. 柱状图中最大的矩形
public class _84 {
    // public int largestRectangleArea(int[] heights) {
    //     int max = 0;
    //     int N = heights.length;
    //     for (int i = 0; i < N; i++) {
    //         int l = i, r = i;
    //         while(l >=0 && heights[l] >= heights[i]) l --;
    //         while(r < N && heights[r] >= heights[i]) r ++;
    //         int ans = (r - l - 1) * heights[i];
    //         if(max < ans) {max =ans;}
    //     }
    //     return max;
    // }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }

        int res = 0;

        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        Deque<Integer> stack = new ArrayDeque<>(len);
        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);

        for (int i = 1; i < len; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        //计算还为计算出的height[i]高度
        while(!stack.isEmpty()){
            int i = stack.poll();
            int iWidth = len - i - 1;
            int iArea = i * iWidth;
            res = Math.max(res, iArea);
        }
        return res;
    }

}
