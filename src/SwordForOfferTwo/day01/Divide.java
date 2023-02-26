package SwordForOfferTwo.day01;

//剑指 Offer II 001. 整数除法
public class Divide {

    // https://blog.csdn.net/qq_43156556/article/details/122331309
    // 使用位运算，注意溢出部分
    // 当 a 或 b == Integer.MIN_VALUE 时，取反+1是无效的，得到的还是MIN_VALUE
    // 因此我们下面的位移运算需要使用无符号右移 >>> 否则会出现负数
    // 当 b == MIN_VALUE时，如果还是 a>>>i >= b 这时会发现死循环，永远大于负数，所以改为(x >>> i) - y >= 0
    public int divide(int a, int b) {
        if(a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE; //特殊处理，溢出
        int x = a > 0 ? a : negNum(a);
        int y = b > 0 ? b : negNum(b);
        int res = 0;
        for (int i = 31; i > -1; i--) {
            if((x >>> i) - y >= 0){
                res |= (1 << i);
                x = minus(x,y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public boolean isNeg(int a){
        return a < 0;
    }

    public int negNum(int a){
        return add(~a,1);
    }

    public int add(int a,int b){
        int sum = a;
        while(b!=0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public int minus(int a,int b){
        return add(a,negNum(b));
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        divide.divide(-2147483648,1);
    }

}
