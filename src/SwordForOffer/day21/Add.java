package SwordForOffer.day21;

//剑指 Offer 65. 不用加减乘除做加法
public class Add {

    //异或运算就是无进位相加，然后与运算左移一位就是进位信息
    //重复得到的异或值和进位信息继续异或，直到进位信息为0
    public int add(int a, int b) {
        int eor = a ^ b;
        int cur = (a & b) << 1;
        int res = eor;
        while(cur != 0){
            res = eor^cur;
            cur = (eor & cur) << 1;
            eor = res;
        }
        return res;
    }

}
