package problem_7XX;

public class _799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] ca = new double[100][100];
        ca[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <=i ; j++) {
                double res = ca[i][j] - 1.0;
                if(res>0){
                    ca[i+1][j] += res / 2;
                    ca[i+1][j+1] += res / 2;
                }
            }
        }
        return ca[query_row][query_glass]>1?1:ca[query_row][query_glass];
        
    }
}
