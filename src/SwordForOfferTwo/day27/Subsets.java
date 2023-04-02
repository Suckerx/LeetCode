package SwordForOfferTwo.day27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指 Offer II 079. 所有子集
public class Subsets {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    //递归回溯
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }

    public void dfs(int cur,int[] nums){
        if(cur == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[cur]);
        dfs(cur + 1,nums);
        temp.remove(temp.size() -  1);
        dfs(cur + 1,nums);
    }

}
