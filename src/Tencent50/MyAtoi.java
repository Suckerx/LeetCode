package Tencent50;

//8. 字符串转换整数 (atoi)
public class MyAtoi {

    public int myAtoi(String s) {
        String trim = s.trim();
        if(trim.length() == 0 || trim.equals("")) return 0;
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < trim.length(); i++) {
            if(i == 0 && (trim.charAt(0) == '-' || trim.charAt(0) == '+')){
                if(trim.charAt(0) == '-') flag = true;
                continue;
            }
            if(trim.charAt(i) - '0' <= 9 && trim.charAt(i) - '0' >= 0){
                res = res * 10 + trim.charAt(i) - '0';
                if(res < 0 || res % 10 != trim.charAt(i) - '0'){
                    return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
            else break;
        }
        return flag ? -1 * res : res;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        myAtoi.myAtoi("   -42");
    }

}
