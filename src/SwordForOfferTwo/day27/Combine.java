package SwordForOfferTwo.day27;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer II 080. 含有 k 个元素的组合
public class Combine {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int k = 0;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(1,n);
        return res;
    }

    //https://leetcode.cn/problems/uUsW3B/solutions/1411895/han-you-k-ge-yuan-su-de-zu-he-by-leetcod-tyqe/
    public void dfs(int cur,int n){
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return ;
        }
        if(cur == n + 1) return ;
        temp.add(cur);
        dfs(cur + 1,n);
        temp.remove(temp.size() -  1);
        dfs(cur + 1,n);
    }

}
