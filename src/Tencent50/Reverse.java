package Tencent50;

//7. 整数反转
public class Reverse {

    public int reverse(int x) {
        boolean flag = x < 0 ? true : false;
        x = x < 0 ? -1 * x : x;
        int res = 0;
        while(x!=0){
            int tem = x % 10;
            res = res * 10 + tem;
            if(res < 0 || res % 10 != tem) return 0;
            System.out.println(res);
            x /= 10;
        }
        return flag == true ? -1 * res : res;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        reverse.reverse(1534236469);
    }

}
