package Tencent50;

//59. 螺旋矩阵 II
public class GenerateMatrix_059 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = 0,col = 0;
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        for (int i = 1; i <= n * n; i++) {
            res[row][col] = i;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != 0){
                directionIndex = (directionIndex + 1) % 4;
            }
            row+=directions[directionIndex][0];
            col+=directions[directionIndex][1];
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateMatrix_059 res = new GenerateMatrix_059();
        res.generateMatrix(3);
    }

}
