package Tencent50;

import java.util.ArrayList;
import java.util.List;

//89. 格雷编码
public class GrayCode_089 {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) { // 左移n位就是2的n次方
            res.add(gray(i));
        }
        return res;
    }

    public int gray(int n){
        return n ^ (n >> 1);
    }

}
