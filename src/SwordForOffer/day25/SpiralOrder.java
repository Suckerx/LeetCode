package SwordForOffer.day25;

//剑指 Offer 29. 顺时针打印矩阵
public class SpiralOrder {

    //因此，考虑设定矩阵的“左、上、右、下”四个边界，模拟以上矩阵遍历顺序。
    //https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solutions/129360/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 ) return new int[0];
        int l = 0,r = matrix[0].length-1,t = 0,b = matrix.length-1,x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true){
            for (int i = l; i <= r; i++) res[x++] = matrix[l][i];
            if(++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if(l > --r) break;
            for (int i = r; i >= l ; i--) res[x++] = matrix[b][i];
            if(t > --b) break;
            for (int i = b; i >= t ; i--) res[x++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;
    }

}
