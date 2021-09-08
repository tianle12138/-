package problem_2XX;

import javax.xml.stream.events.EndElement;

public class _240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int r = m - 1;
        int c = 0;
        while (r >= 0 && c <= n - 1) {
            if(matrix[r][c] > target) {
                r --;
            } else if(matrix[r][c] < target){
                c ++;
            } else {
                return true;
            }
        }
        return false;
    }
}
