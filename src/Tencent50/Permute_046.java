package Tencent50;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.List;

//46. 全排列
public class Permute_046 {

    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();
    boolean[] flag;

    //回溯
    public List<List<Integer>> permute(int[] nums) {
        flag = new boolean[nums.length];
        process(nums);
        return res;
    }

    public void process(int[] nums){
        if(temp.size() == nums.length) res.add(new ArrayList<>(temp));
        for (int i = 0; i < nums.length; i++) {
            if(flag[i]) continue;
            temp.add(nums[i]);
            flag[i] = true;
            process(nums);
            temp.remove(temp.size() - 1);
            flag[i] = false;
        }
    }

}
