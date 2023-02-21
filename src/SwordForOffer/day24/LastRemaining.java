package SwordForOffer.day24;

//剑指 Offer 62. 圆圈中最后剩下的数字
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        if(n == 1) return 0;
        return process(n,m);
    }

    //左神推导公式：旧 = (新 + m - 1) % n - 1
    public int process(int n, int m) {
        if(n == 1) return 1;
        return (process(n-1,m) + m -1) % n + 1;
    }

    /**
     * 图中的绿色的线指的是新的一轮的开头是怎么指定的，每次都是固定地向前移位 mmm 个位置。
     *
     * 然后我们从最后剩下的 3 倒着看，我们可以反向推出这个数字在之前每个轮次的位置。
     *
     * 最后剩下的 3 的下标是 0。
     *
     * 第四轮反推，补上 mmm 个位置，然后模上当时的数组大小 222，位置是(0 + 3) % 2 = 1。
     *
     * 第三轮反推，补上 mmm 个位置，然后模上当时的数组大小 333，位置是(1 + 3) % 3 = 1。
     *
     * 第二轮反推，补上 mmm 个位置，然后模上当时的数组大小 444，位置是(1 + 3) % 4 = 0。
     *
     * 第一轮反推，补上 mmm 个位置，然后模上当时的数组大小 555，位置是(0 + 3) % 5 = 3。
     *
     * 所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
     *
     * 总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。
     *
     * 代码就很简单了。
     *
     * 作者：Sweetiee🍬的小号
     * 链接：https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solutions/177639/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int lastRemaining1(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
