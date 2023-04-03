package SwordForOfferTwo.day28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指 Offer II 082. 含有重复元素集合的组合
public class CombinationSum2 {

    //https://leetcode.cn/problems/4sjJUc/solutions/992230/java-hui-su-jian-zhi-jiao-ni-ru-he-bi-mi-nx9y/?orderBy=hot
    //排序 + 回溯 + 剪枝

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target);
        return res;
    }

    public void dfs(int[] candidates,int idx,int target){
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if(candidates[i] > target) break;
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            dfs(candidates,i + 1,target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

}
