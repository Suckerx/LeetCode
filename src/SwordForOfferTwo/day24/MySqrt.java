package SwordForOfferTwo.day24;

//剑指 Offer II 072. 求平方根
public class MySqrt {

    public int mySqrt(int x) {
        if(x == 0) return 0;
        int left = 1;
        int right = x / 2;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return ans;
    }

    //https://leetcode.cn/problems/jJ0w9p/solutions/1398892/qiu-ping-fang-gen-by-leetcode-solution-ybnw/
    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

}
