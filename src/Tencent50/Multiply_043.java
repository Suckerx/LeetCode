package Tencent50;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//43. 字符串相乘
public class Multiply_043 {

    //https://leetcode.cn/problems/multiply-strings/solutions/29100/you-hua-ban-shu-shi-da-bai-994-by-breezean/?orderBy=hot
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        for (int i = num2.length() - 1; i >= 0 ; i--) {
            int carry = 0;
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            for (int j = num1.length() - 1; j >= 0 || carry != 0 ; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int x = ((num2.charAt(i) - '0' ) * n1 + carry) % 10;
                temp.append(x);
                carry = ((num2.charAt(i) - '0' ) * n1 + carry) / 10;
            }
            res = addString(res,temp.reverse().toString());
        }
        return res;
    }

    public String addString(String num1,String num2){
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1 , j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0 ;
             i--,j--) {
            int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            res.append((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;
        }
        return res.reverse().toString();
    }

}
