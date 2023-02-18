package SwordForOffer.day16;

import java.io.Reader;
import java.util.Arrays;
import java.util.List;

//面试题45. 把数组排成最小的数
public class MinNumber {
    /**
     * 此题求拼接起来的最小数字，本质上是一个排序问题。设数组 nums 中任意两数字的字符串为 x 和 y ，则规定 排序判断规则 为：
     * 若拼接字符串 x+y>y+x ，则 x “大于” y ；
     * 反之，若 x+y<y+x，则 x “小于” y ；
     */

    //使用内置函数进行排序
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //这样写是升序，如果要逆序则改为 -(x+y).compareTo(y+x)
        Arrays.sort(strs,(x,y) -> (x+y).compareTo(y+x));//lambda表达式简写，字符串比较函数compareTo
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    //使用快速排序，自定义排序规则
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs,0,strs.length-1);
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}
