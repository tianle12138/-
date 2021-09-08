package problem_6XX;

public class _659 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;

    }

    private int area(int[][] grid, int r, int c) {
        if(!inArea(grid,r,c)){
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return 1
                + area(grid, r - 1, c)
                + area(grid, r + 1, c)
                + area(grid, r, c - 1)
                + area(grid, r, c + 1);
        
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
