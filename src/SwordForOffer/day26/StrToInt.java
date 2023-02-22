package SwordForOffer.day26;

//面试题67. 把字符串转换成整数
public class StrToInt {

    //https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/solutions/201301/mian-shi-ti-67-ba-zi-fu-chuan-zhuan-huan-cheng-z-4/

    /**
     * 关于代码中对于越界的判断的一个小细节说一点我的理解 简单来说就是如果直接向int变量赋值-2147483648系统会报错，虽然理论上确实可以取到，但是直接赋值不行，下面是详细讨论。
     *
     * if(res > bndry || res == bndry && str.charAt(j) > '7')
     * 即INT_MIN明明是-2147483648，但是为什么却只需要判断当前字符是否大于7，因为按常理来说当符号为负时str.charAt(j)为'8'也是不越界的，但是为什么这里只判断‘7’呢？ 这是因为我们如果直接向一个int变量赋值-2147483648，系统是会报错的（至少在C++中是这样），我们如果想要返回这个数那就需要使用INT_MIN，因为INT_MIN=-2147483648。 那么我们回过头来看这题，考虑字符串为“-2147483648”这种情况，即res==214748364的前提下，当前字符是‘8’，那么按照最常规的思路，这个数是在int的取值范围中，那么我要存放它，但是int变量并不能直接存放这个数，因此我要找一个与-2147483648相等的，可以表示它的数，那就是INT_MIN。因此即使符号是负号，我们仍然可以将判断条件写为 str.charAt(j) > '7' ，因为当取‘8’时我们返回的也是INT_MIN。
     *
     * 关于为什么不能直接向int变量赋值-2147483648，我搜索了一些资料，大致意思是说-2147483648是一个常量表达式而非常量，系统会把它分成两部分，即负号 - 和 数字 2147483648，因此会出现越界的情况。
     *
     * 当然啦，即使int变量能存放下-2147483648，我们依然可以这么写 str.charAt(j) > '7' ，只是这么些会有一点违反我们的直觉，需要思考一下过程才能理解，因此在这里分享一点我的看法，希望能帮助到有同样疑惑的朋友。
     */
    public int strToInt(String str) {
        char[] s = str.trim().toCharArray();
        if(s.length == 0) return 0;
        int binary = Integer.MAX_VALUE / 10;
        int res = 0,sign = 1,i = 1;
        if(s[0] == '-') sign = -1;
        else if(s[0] != '+') i = 0;
        for (int j = i; j < s.length; j++) {
            if(s[j] < '0' || s[j] > '9') break;
            if(res > binary || res == binary && s[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s[j] - '0');
        }
        return res * sign;
    }

}
