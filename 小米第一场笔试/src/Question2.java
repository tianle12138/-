

public class Question2 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'}
        };
        Question2 clazz = new Question2();
        boolean res = clazz.exist(board, "abcfd");
        System.out.println(res);
    }

    int[][] visited;
    int w;
    int h;
    public boolean exist(char[][] board, String word) {
        w = board[0].length;
        h = board.length;
        visited = new int[h][w];
        char[] tar = word.toCharArray();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == tar[0]) {
                    boolean res = match(board, i, j, tar, 1);
                    if (res) return true;
                }
                continue;
            }
        }
        return false;
    }

    private boolean match(char[][] board, int i, int j, char[] tar, int index) {
        if (index >= tar.length) return true;

        visited[i][j] = 1;
        boolean flag = false;
        if (!flag && isValid(i, j + 1)) {
            if(board[i][j+1] == tar[index]) {
                flag = flag || match(board, i, j+1, tar, index + 1);
            }
        }
        if (!flag && isValid(i, j - 1)) {
            if(board[i][j-1] == tar[index]) {
                flag = flag || match(board, i, j-1, tar, index + 1);
            }
        }
        if (!flag && isValid(i+1, j)) {
            if(board[i+1][j] == tar[index]) {
                flag = flag || match(board, i+1, j, tar, index + 1);
            }
        }
        if (!flag && isValid(i-1, j)) {
            if(board[i-1][j] == tar[index]) {
                flag = flag || match(board, i-1, j, tar, index + 1);
            }
        }

        visited[i][j] = 0;
        return flag;
    }

    private boolean isValid( int row, int col) {
        if(row >=0 && row < h && col >= 0 && col < w){
            if(visited[row][col] != 1)return true;
        }
        return false;
    }

}
