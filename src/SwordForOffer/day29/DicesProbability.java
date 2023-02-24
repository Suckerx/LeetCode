package SwordForOffer.day29;

//剑指 Offer 60. n个骰子的点数
public class DicesProbability {

    /**
     * 递归
     * n个骰子，我们可以投掷n次，累加每次掷出的点数即可。因此要求出n个骰子的点数和，
     * 可以从n个骰子先取出一个投掷，这一个骰子只可能出现1-6中的某一个数，我们需要计算的是1-6每个点数与剩下n -1个骰子的点数和；
     * 接下来进行第二次投掷，现在骰子堆中还有n - 1个骰子，对于这n -1个骰子，继续从中选一个出来投掷，
     * 并在上次掷出的点数上累加…这显然是个递归过程。不断投掷，直到最后一个骰子也被投掷并累加点数，之后骰子数为0，也达到了递归终止的条件。
     *
     * 一个骰子可能出现的点数和是1-6，两个骰子可能出现的点数和为2-12,三个骰子可能出现的点数和为3-18，
     * 因此n个骰子可能出现的点数为n-6n。可以用一个大小为6n - n + 1的数组存放每个可能的点数和出现的频率，
     * 比如该数组下标0处存放的是点数和为n的出现次数；而下标6n -n处存放的是点数和6n的出现次数。n个骰子，
     * 每次投掷都有6种情况，因此总的点数和情况为6^n种。要求某个点数和出现的概率，用该点数和出现的频次除以6^n即可。
     */
    public double[] dicesProbability(int n) {
        double[] res = new double[6*n - n + 1];
        int[] p = new int[6*n - n + 1];
        process(n,n,0,p);
        double total = Math.pow(6,n);
        for (int i = n; i <= 6*n; i++) {
            res[i-n] = p[i-n] / total;
        }
        return res;
    }

    public void process(int n,int cur ,int sum,int[] p){
        if(cur == 0) p[sum - n]++;//递归到没有骰子的时候，和为 s 的点数出现的次数保存到数组的第 s - n 个元素里。
        else{
            for (int i = 1; i <= 6; i++) {
                process(n,cur - 1,sum + i,p);
            }
        }
    }

    //https://blog.csdn.net/wq6ylg08/article/details/108656294
    public double[] dicesProbability2(int n) {//dp[i][j] 表示骰子个数为i时点数和为j时的次数
        double[] res = new double[6*n - n + 1];
        double[][] dp = new double[n+1][6*n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i*6 ; j++) {
                for (int k = 1; j > k && k <= 6 ; k++) {//注意，这里倒推是指i -1个骰子掷出s-1、s-2、s-3、s-4、s-5、s-6的情况数总和就是k个骰子掷出点数和s的情况数
                    dp[i][j] += dp[i-1][j-k]; // 但是要注意，倒着减会越界，控制 j > k
                }
            }
        }

        double total = Math.pow(6,n);
        for (int i = n; i <= 6*n; i++) {
            res[i-n] = dp[n][i] / total;
        }
        return res;
    }

}
