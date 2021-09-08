package problem_2XX;

public class _200 {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]=='1') {
                    expend(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void expend(char[][] grid, int i, int j) {
        if(!inArea(grid,i,j) || grid[i][j]!='1'){
            return ;
        }
        grid[i][j] = '2';
        expend(grid,i+1,j);
        expend(grid,i-1,j);
        expend(grid,i,j+1);
        expend(grid,i,j-1);
    }

    private boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && c >= 0 && c < grid[0].length;
    }


    public int numIslands_org(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] sign = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !sign[i][j]) {
                    bfs(grid, sign, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] sign, int i, int j) {
        sign[i][j] = true;
        if (isValid(grid, sign, i + 1, j)) {
            bfs(grid, sign, i + 1, j);
        }
        if (isValid(grid, sign, i - 1, j)) {
            bfs(grid, sign, i - 1, j);
        }
        if (isValid(grid, sign, i, j + 1)) {
            bfs(grid, sign, i, j + 1);
        }
        if (isValid(grid, sign, i, j - 1)) {
            bfs(grid, sign, i, j - 1);
        }
    }

    private boolean isValid(char[][] grid, boolean[][] sign, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return false;
        }
        if(grid[i][j] == '0' || sign[i][j]){
            return false;
        }
        return true;
    }
}
