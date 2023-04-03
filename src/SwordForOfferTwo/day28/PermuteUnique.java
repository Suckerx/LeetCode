package SwordForOfferTwo.day28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指 Offer II 084. 含有重复元素集合的全排列
public class PermuteUnique {

    boolean[] vis;

    //https://leetcode.cn/problems/7p8L0Z/solutions/1404273/han-you-zhong-fu-yuan-su-ji-he-de-quan-p-qxwv/?orderBy=hot&languageTags=java
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,res,temp,0);
        return res;
    }

    public void backtrack(int[] nums,List<List<Integer>> res,List<Integer> temp,int idx){
        if(idx == nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1]) ) continue;
            temp.add(nums[i]);
            vis[i] = true;
            backtrack(nums,res,temp,idx + 1);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}
