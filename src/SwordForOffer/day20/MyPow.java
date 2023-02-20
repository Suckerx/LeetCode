package SwordForOffer.day20;

//剑指 Offer 16. 数值的整数次方
public class MyPow {

    //快速幂实际上是二分思想的一种应用。

    /**
     *Java 代码中 int32 变量 n∈[−2147483648,2147483647]，
     * 因此当 n=−2147483648n = -2147483648n=−2147483648 时执行 n=−n会因越界而赋值出错。解决方法是先将 n存入 long 变量 b ，后面用 bbb 操作即可。
     * x是底数，n是指数，ans是结果，x^n代表的是一个数值，
     * 快速幂说白了就是在确保数值不变的情况下，
     * 用二分法把数值从指数不断地往底数里面搬。核心是n=n/2, x=x^2这两句代码。
     * 但是由于指数可能是奇数，整数除二会丢失一位底数，所以要在ans里面记录奇数轮丢失的底数。
     */
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        if(b < 0){
            x = 1/x;
            b = -b;
        }
        double res = 1.0;
        while(b > 0){
            if((b & 1) == 1) res*=x; //取余数 n%2等价于 判断二进制最右一位值 n&1 ；
            x*=x;
            b>>=1; //位运算表示 b/2 的向下取整
        }
        return res;
    }

}
