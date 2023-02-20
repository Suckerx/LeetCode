package SwordForOffer.day21;

//剑指 Offer 15. 二进制中1的个数
public class HammingWeight {

    //根据 与运算 定义，设二进制数字 nnn ，则有：
    //若 n&1=0，则 n 二进制 最右一位 为 0 ；
    //若 n&1=1，则 n 二进制 最右一位 为 1 。
    //Java 中无符号右移为 ">>>"
    //右移为 >>
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0){
            res+=n&1;
            n >>>= 1;//将 n 右移一位（本题要求把数字 n 看作无符号数，因此使用 无符号右移 操作）。
        }
        return res;
    }

}
