package SwordForOffer.day23;

//剑指 Offer 66. 构建乘积数组
public class ConstructArr {

    //位运算除法，注意数组中含有多个0
    public int[] constructArr(int[] a) {
        int res = 1;
        int res1 = 1;
        int zero = 0;
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res *= a[i];
            if(a[i]!=0){
                res1*=a[i];
            }
            if(a[i] == 0) zero++;
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=0) b[i] = div(res,a[i]);
            else{
                if(zero > 1) b[i] = 0;
                else b[i] = res1;
            }
        }
        return b;
    }

    public boolean isNeg(int a){
        return a < 0;
    }

    public int div(int a,int b){
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i  > -1; i = minus(i,1)) {
            if((x >> i) >= y){
                res |= (1 << i);
                x = minus(x,(y << i));
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public int negNum(int n){
        return add(~n,1);
    }
    public int add(int a,int b){
        int sum = 0;
        while(b!=0){
            sum = a^b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }
    public int minus(int a,int b){
        return add(a,negNum(b));
    }

    //表格分区解法：本质上是dp数组，分别维护 i 左侧、右侧的乘积和
    public int[] constructArr1(int[] a){
        if(a == null || a.length == 0) return a;
        int len = a.length;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[] res = new int[a.length];
        left[0] = right[len-1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] * a[i-1];
        }

        for (int i = len-2; i >= 0 ; i++) {
            right[i] = right[i+1] * a[i+1];
        }

        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }


}
