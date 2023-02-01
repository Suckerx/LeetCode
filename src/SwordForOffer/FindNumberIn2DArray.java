package SwordForOffer;

import javax.xml.bind.annotation.XmlID;

//剑指 Offer 04. 二维数组中的查找
public class FindNumberIn2DArray {

    // 解法一： 每一行上用二分，O(NlogM)
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int left = 0;
            int right = row.length-1;
            while(left <= right){
                int mid = left + (right-left)/2;
                if(row[mid] > target ) right = mid - 1;
                else if(row[mid] < target ) left = mid + 1;
                else if(row[mid] == target) return true;
            }
        }
        return false;
    }

    // 解法二： 如下图所示，我们将矩阵逆时针旋转 45° ，
    // 并将其转化为图形式，发现其类似于 二叉搜索树 ，即对于每个元素，其左分支元素更小、右分支元素更大。
    // 因此，通过从 “根节点” 开始搜索，遇到比 target 大的元素就向左，反之向右，即可找到目标值 target 。
//    “根节点” 对应的是矩阵的 “左下角” 和 “右上角” 元素，本文称之为 标志数 ，以 matrix 中的 左下角元素 为标志数 flag ，则有:
//
//    若 flag > target ，则 target 一定在 flag 所在 行的上方 ，即 flag 所在行可被消去。
//    若 flag < target ，则 target 一定在 flag 所在 列的右方 ，即 flag 所在列可被消去。

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;
        while(i>=0 && j<=matrix[0].length-1){
            if(matrix[i][j] > target ) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }

}
