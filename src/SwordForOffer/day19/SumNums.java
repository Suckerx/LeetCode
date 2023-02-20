package SwordForOffer.day19;

//剑指 Offer 64. 求1+2+…+n
public class SumNums {

    //常见的逻辑运算符有三种，即 “与 &&\&\&&& ”，“或 ∣∣||∣∣ ”，“非 !!! ” ；而其有重要的短路效应，如下所示：
    //本题需要实现 “当 n=1n = 1n=1 时终止递归” 的需求，可通过短路效应实现。
    //  n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n-1) > 0;
        res += n;
        return res;
    }

}
