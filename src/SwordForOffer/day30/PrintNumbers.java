package SwordForOffer.day30;

import java.util.ArrayList;

//剑指 Offer 17. 打印从1到最大的n位数
public class PrintNumbers {

    public int[] printNumbers(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = end * 10 + 9;
        }
        for (int i = 1; i <= end; i++) {
            list.add(i);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    //大数打印解法：
    //实际上，本题的主要考点是大数越界情况下的打印。需要解决以下三个问题：
    /**
     * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solutions/278565/mian-shi-ti-17-da-yin-cong-1-dao-zui-da-de-n-wei-2/
     * 1. 表示大数的变量类型：
     * 2. 生成数字的字符串集：
     *3. 递归生成全排列：
     */
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers1(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

}
