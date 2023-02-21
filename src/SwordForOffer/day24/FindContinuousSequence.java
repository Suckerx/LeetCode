package SwordForOffer.day24;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer 57 - II. 和为s的连续正数序列
public class FindContinuousSequence {

    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        int i = 1,j = 2,s = 3;
        List<int[]> list = new ArrayList<>();
        while(i < j){
            if(s == target){
                int[] a = new int[j-i+1];
                for (int k = i; k <= j; k++) {
                    a[k-i] = k;
                }
                list.add(a);
            }
            if(s >= target){//左指针右移
                s-=i;
                i++;
            }
            else{
                j++;
                s+=j;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    //利用求和公式
    /**
     *设连续正整数序列的左边界 i 和右边界 j ，则此序列的 元素和 target 等于 元素平均值 (i+j)/2乘以 元素数量 (j−i+1) ，即：
     * target = (i+j) * (j-i+1) / 2
     * 观察发现，当确定 元素和 target 与 左边界 i 时，可通过 解一元二次方程 ，直接计算出右边界 j ，公式推导如下
     * 根据一元二次方程求根公式得：
     * 由于 j>i 恒成立，因此直接 舍去必为负数的解 ，即 j 的唯一解求取公式为
     * 因此，通过从小到大遍历左边界 i 来计算 以 i 为起始数字的连续正整数序列 。每轮中，由以上公式计算得到右边界 j
     * ，当 j 满足以下两个条件时记录结果：
     * j 为 整数 ：符合题目所求「连续正整数序列」；
     * i<j ：满足题目要求「至少含有两个数」；
     */
    public int[][] findContinuousSequence1(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> list = new ArrayList<>();
        while(i < j){
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if(i < j && j == (int) j){
                int[] a = new int[(int)j - i + 1];
                for (int k = i; k <= (int)j ; k++) {
                    a[k-i] = k;
                }
                list.add(a);
            }
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

}
