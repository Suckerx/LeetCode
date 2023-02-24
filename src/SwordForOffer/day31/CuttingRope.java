package SwordForOffer.day31;

//剑指 Offer 14- II. 剪绳子 II
public class CuttingRope {

    //循环求余法
    public int cuttingRope(int n) {
        if(n <= 3)
            return n - 1;
        int b = n % 3, p = 1000000007;
        long ret = 1;
        int lineNums=n/3;           //线段被我们分成以3为大小的小线段个数
        for(int i=1;i<lineNums;i++) //从第一段线段开始验算，3的ret次方是否越界。注意是验算lineNums-1次。
            ret = 3*ret % p;
        if(b == 0)
            return (int)(ret * 3 % p);   //刚好被3整数的，要算上前一段
        if(b == 1)
            return (int)(ret * 4 % p);   //被3整数余1的，要算上前一段

        return (int)(ret * 6 % p);       //被3整数余2的，要算上前一段
    }

    //快速幂求解
    // rem 用于保存奇数部分的乘积，偶数除以二可能为奇数
    //https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/solutions/106190/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
    public int cuttingRope2(int n) {
        if(n <= 3) return n-1;
        long rem = 1,x = 3;
        int b = n % 3, p = 1000000007;
        for (int a = n/3 - 1; a > 0 ; a/=2) { //只算了 n/3 - 1 次，还剩下了一截 3
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int) (rem * 3 % p);
        if(b == 1) return (int) (rem * 4 % p);
        if(b == 2) return (int) (rem * 6 % p);
        return (int) rem;
    }

}
