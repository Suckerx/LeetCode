package SwordForOfferTwo.day27;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer II 081. 允许重复选择元素的组合
public class CombinationSum {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    //https://leetcode.cn/problems/Ygoe9J/solutions/1404271/yun-xu-zhong-fu-xuan-ze-yuan-su-de-zu-he-gvs0/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0);
        return res;
    }

    public void dfs(int[] candidates,int target,int idx){
        if(idx == candidates.length) return;
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        dfs(candidates,target,idx + 1);
        if(target - candidates[idx] >= 0){
            temp.add(candidates[idx]);
            dfs(candidates,target - candidates[idx],idx);
            temp.remove(temp.size() - 1);
        }
    }

}
