
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] price = {2, 3, 5, 4};
        System.out.println(main.putGems(price, 2));
    }

    public int putGems (int[] price, int k) {
        int n = price.length;
        int[][] dp = new int[k + 1][n]; // 动态规划数组，dp[i][j]表示使用i个行囊，前j个宝石的最大价值

        for (int i = 0; i < n; i++) {
            dp[0][i] = 0; // 初始化使用0个行囊的情况，价值都为0
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = price[j] + dp[i - 1][j]; // 默认情况下，第i个行囊包含第j个宝石，价值为price[j]加上前i-1个行囊的最大价值
                for (int t = 0; t < j; t++) {
                    dp[i][j] = Math.max(dp[i][j], price[j] + price[t] + dp[i - 1][t]); // 考虑将第j个宝石和第t个宝石放入同一个行囊的情况
                }
            }
        }

        int maxScore = Arrays.stream(dp[k]).max().getAsInt(); // 最大分数
        int minScore = Arrays.stream(dp[k]).min().getAsInt(); // 最小分数

        return maxScore - minScore;
    }

}