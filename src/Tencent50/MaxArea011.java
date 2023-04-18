package Tencent50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//11. 盛最多水的容器
public class MaxArea011 {

    //双指针
    //https://leetcode.cn/problems/container-with-most-water/solutions/11491/container-with-most-water-shuang-zhi-zhen-fa-yi-do/?orderBy=hot
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0,right = height.length - 1;
        while(left < right){
            res = Math.max(res,Math.min(height[left],height[right]) * (right - left));
            if(height[left] <= height[right]) left++;
            else right -- ;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea011 maxArea011 = new MaxArea011();
        maxArea011.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }

}
