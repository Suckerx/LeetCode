package Tencent50;

//169. 多数元素
public class MajorityElement_169 {

    //摩尔投票法
    //https://leetcode.cn/problems/majority-element/solutions/146811/3chong-fang-fa-by-gfu-2/?orderBy=hot
    public int majorityElement(int[] nums) {
        int num = nums[0],count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == num){
                count++;
            }else if(--count == 0){
                num = nums[i];
                count = 1;
            }
        }
        return num;
    }

}
