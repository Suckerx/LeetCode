package SwordForOffer.day22;

//剑指 Offer 56 - II. 数组中数字出现的次数 II
public class SingleNumber {

    //以二进制形式看待数据，只有一个数出现了一次，其他数都出现了三次 将每一位为1的位累加，再%3，就是只出现一次的数
    public int singleNumber(int[] nums) {
        int[] a = new int[32];

        for (int i : nums) {
            for (int j = 0; j < 32; j ++) {
                if ((i >> j & 1) == 1) a[j] = (a[j] + 1) % 3;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i ++)
            if (a[i] == 1) res = res | (1 << i);

        return res;
    }

    //https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solutions/1161386/ji-yu-krahetsda-lao-gei-chu-de-you-xian-67dkc/
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }


}
