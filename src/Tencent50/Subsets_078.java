package Tencent50;

import java.util.ArrayList;
import java.util.List;

//78. 子集
public class Subsets_078 {

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();

    //递归回溯
    public List<List<Integer>> subsets(int[] nums) {
        process(nums,0);
        return res;
    }

    public void process(int[] nums,int cur){
        if(cur == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[cur]);
        process(nums,cur + 1);
        temp.remove(temp.size() - 1);
        process(nums,cur + 1);
    }

}
