package Tencent50;

//136. 只出现一次的数字
public class SingleNumber_136 {

    //异或运算
    public int singleNumber(int[] nums) {
        int eor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            eor ^= nums[i];
        }
        return eor;
    }

}
