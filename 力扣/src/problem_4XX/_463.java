package problem_4XX;

import java.awt.datatransfer.ClipboardOwner;

public class _463 {

    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int P = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==1){
                    P+=calP(grid,i,j);
                }
            }
        }
        return P;
    }

    private int calP(int[][] grid, int i, int j) {
        return 4 - isValid(grid,i+1,j) -  isValid(grid,i-1,j) -isValid(grid,i,j+1)- isValid(grid,i,j-1);
    }

    private int isValid(int[][] grid, int r, int c) {
        if(r<0||r>=grid.length||c<0||c>=grid[0].length)
            return 0;
        if(grid[r][c] == 1)
            return 1;
        else return 0;
    }


    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int P = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==1){
                    P += getPerimeter(grid,i,j);
                }
            }
        }
        return P;
    }

    private int getPerimeter(int[][] grid, int r, int c) {
        // 函数因为「坐标 (r, c) 超出网格范围」返回，对应一条黄色的边
        if (!inArea(grid, r, c)) {
            return 1;
        }
        // 函数因为「当前格子是海洋格子」返回，对应一条蓝色的边
        if (grid[r][c] == 0) {
            return 1;
        }
        // 函数因为「当前格子是已遍历的陆地格子」返回，和周长没关系
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return getPerimeter(grid, r - 1, c)
                + getPerimeter(grid, r + 1, c)
                + getPerimeter(grid, r, c - 1)
                + getPerimeter(grid, r, c + 1);



    }

    private boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && c >= 0 && c < grid[0].length;
    }
}
