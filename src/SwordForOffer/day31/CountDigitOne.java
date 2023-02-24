package SwordForOffer.day31;

//剑指 Offer 43. 1～n 整数中 1 出现的次数
public class CountDigitOne {

    //这题的易得，考虑密码锁，固定一位是1，其他不管怎么动，都有个1存在
    //https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solutions/229751/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
    public int countDigitOne(int n) {
        int digit = 1,res = 0;
        int low = 0, high = n / 10, cur = n % 10;
        while(high != 0 || cur != 0){
            if(cur == 0) res += high * digit;
            else if(cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }

}
