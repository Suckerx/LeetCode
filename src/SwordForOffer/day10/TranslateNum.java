package SwordForOffer.day10;

//剑指 Offer 46. 把数字翻译成字符串
public class TranslateNum {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        return process(chars,0);
    }

    public static int process(char[] num,int i){
        if(i == num.length) return 1;
        if(num[i] == '0'){
            int res = process(num,i+1);
            return res;
        }
        if(num[i] == '1'){
            int res = process(num,i+1);
            if(i+1<num.length) res+=process(num,i+2);
            return res;
        }
        if(num[i] == '2'){
            int res = process(num,i+1);
            if(i+1<num.length && (num[i+1]>='0' && num[i+1] <= '5')) res+=process(num,i+2);
            return res;
        }
        return process(num,i+1);
    }


    public int translateNum2(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] dp = new int[length+1];

        if(length == 1) return 1;

        dp[length]=1;
        dp[length-1]=1;

        for (int i = length-2; i >= 0; i--) {
            if(chars[i] == '0'){
                dp[i] = dp[i+1];
            }
            else if(chars[i] == '1'){
                dp[i] = dp[i+1];
                if(i+1<length) dp[i]+=dp[i+2];
            }
            else if(chars[i] == '2'){
                dp[i] = dp[i+1];
                if(i+1<length && (chars[i+1]>='0' && chars[i+1] <= '5')) dp[i]+=dp[i+2];
            }
            else dp[i] = dp[i+1];
            System.out.println(dp[i]);
        }
        return dp[0];
    }


    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        System.out.println(translateNum.translateNum2(220));
    }

}
