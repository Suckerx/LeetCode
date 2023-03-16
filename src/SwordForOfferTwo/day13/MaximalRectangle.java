package SwordForOfferTwo.day13;

//剑指 Offer II 040. 矩阵中最大的矩形
public class MaximalRectangle {

    //单调栈。同上一题思路，将其转换为求直方图面积
    //https://leetcode.cn/problems/PLYXKQ/solutions/1277307/hua-luo-yue-que-zhi-fang-tu-zui-da-ju-xi-cvaj/
    public int maximalRectangle(String[] matrix) {
        if(matrix.length == 0) return 0;
        int res = 0;
        int[] heights = new int[matrix[0].length()];
        for (String s : matrix) {
            for (int i = 0; i < s.length(); i++) {
                heights[i] = s.charAt(i) == '0' ? 0 : heights[i] + 1;
            }
            res = Math.max(res,maxArea(heights));
        }
        return res;
    }

    public int maxArea(int[] heights){
        int res = 0;
        int index = 1;
        int[] stack = new int[heights.length + 1];//采用数组模拟栈，因为数据量比较小
        stack[0] = -1;
        for (int i = 0; i < heights.length; i++) {
            while(index > 0 && heights[stack[index]] >= heights[i]){
                res = Math.max(res,heights[stack[index--]] * (i - stack[index] - 1));
            }
            stack[++index] = i;
        }
        while(index > 0){
            res = Math.max(res,heights[stack[index--]] * (heights.length - stack[index] - 1));
        }
        return res;
    }

}
