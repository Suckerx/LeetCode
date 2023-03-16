package SwordForOfferTwo.day13;

import java.util.*;

//剑指 Offer II 039. 直方图最大矩形面积
public class LargestRectangleArea {

    //单调栈
    //https://leetcode.cn/problems/0ynMMM/solutions/1277173/hua-luo-yue-que-wo-zhen-de-zhen-de-nu-li-ohjt/
    //对当前位置往左右两边找第一个比他小的
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.offerLast(-1);
        for (int i = 0; i < heights.length; i++) {
            while(stack.peekLast() != -1 && heights[stack.peekLast()] >= heights[i]){
                res = Math.max(res,heights[stack.pollLast()] * (i - stack.peekLast() - 1));
            }
            stack.offerLast(i);
        }
        while(stack.peekLast() != -1){
            res = Math.max(res,heights[stack.pollLast()] * (heights.length - stack.peekLast() - 1));
        }
        return res;
    }

}
