package SwordForOfferTwo.day04;

//剑指 Offer II 013. 二维子矩阵的和
public class NumMatrix {

    int[][] sums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        sums = new int[m+10][n+10];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = sums[i][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1 + 1; i <= row2+1 ; i++) {
            ans += sums[i][col2+1] - sums[i][col1];
        }
        return ans;
    }

}
