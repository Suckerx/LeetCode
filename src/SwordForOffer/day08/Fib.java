package SwordForOffer.day08;

//剑指 Offer 10- I. 斐波那契数列
public class Fib {

    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return (fib(n-1) + fib(n-2)) == 1e9+8 ? 1 : fib(n-1) + fib(n-2);
    }

    public int fib1(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] dp = new int[n + 1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (int) ((dp[i-1]+dp[i-2])%(1e9+7));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        fib.fib1(3);
    }

}
