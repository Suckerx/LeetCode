package Tencent50;

import java.util.ArrayList;
import java.util.List;

//54. 螺旋矩阵
public class SpiralOrder_054 {

    //https://leetcode.cn/problems/spiral-matrix/solutions/275393/luo-xuan-ju-zhen-by-leetcode-solution/?orderBy=hot
    //模拟
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];

        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int directIndex = 0;
        int row = 0,col = 0;

        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            res.add(matrix[row][col]);
            flag[row][col] = true;
            int nextRow = row + directions[directIndex][0];
            int nextCol = col + directions[directIndex][1];
            if(nextRow < 0 || nextRow >= matrix.length || nextCol < 0 || nextCol >= matrix[0].length || flag[nextRow][nextCol]){
                directIndex = (directIndex + 1) % 4;
            }
            row+=directions[directIndex][0];
            col+=directions[directIndex][1];
        }
        return res;
    }

}
