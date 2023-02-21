package SwordForOffer.day22;

//剑指 Offer 56 - I. 数组中数字出现的次数
public class SingleNumbers {

    /**
     * 在一堆数中进行异或，最终结果就是a^b，他们肯定不等于0，表示a和b用二进制表示至少有一位是1，
     * 即有一个位置a和b不相同，假设为第8位，
     * 根据这个第8位将原数组进行分类，分为第8位是1的数和第8位是0的数，
     * 而a和b只可能分别在两边，此时用一个变量去异或第8位是1的数，此时这个变量一定是a或者b，再让他和eor进行异或，即可得到另一个数
     */
    public int[] singleNumbers(int[] nums) {
        int eor = 0,rightOne = 0,onlyOne = 0;
        for (int num : nums) {
            eor^=num;
        }
        rightOne = eor & (~eor + 1);
        for (int num : nums) {
            if((num & rightOne) == 0) onlyOne ^= num;
        }
        return new int[]{onlyOne,onlyOne^eor};
    }

}
