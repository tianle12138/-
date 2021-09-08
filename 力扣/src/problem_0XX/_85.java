package problem_0XX;

public class _85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int rectSize = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int curWidth = left[i][j];
                int area = curWidth;
                for (int k = i - 1; k >= 0; k--) {
                    curWidth = Math.min(curWidth, left[k][j]);
                    area = Math.max(area, (i - k + 1) * curWidth);
                }
               rectSize = Math.max(rectSize, area);
            }
        }
        return rectSize;
    }
}
