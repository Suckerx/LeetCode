package SwordForOffer.day28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//剑指 Offer 38. 字符串的排列
public class Permutation {

    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    //https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/solutions/178988/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
    public void dfs(int x){
        if(x == c.length-1){
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue;// 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
