package SwordForOfferTwo.day28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//剑指 Offer II 083. 没有重复元素集合的全排列
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        int n = nums.length;
        backtrack(n,res,temp,0);
        return res;
    }

    public void backtrack(int n,List<List<Integer>> res,List<Integer> temp,int first){
        if(first == n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = first; i < n ; i++) {
            if(i > first){
                if(temp.get(first) == temp.get(i)) continue;
                Collections.swap(temp,first,i);
                backtrack(n,res,temp,first + 1);
                Collections.swap(temp,first,i);
            }else{
                Collections.swap(temp,first,i);
                backtrack(n,res,temp,first + 1);
                Collections.swap(temp,first,i);
            }
        }
    }

}
