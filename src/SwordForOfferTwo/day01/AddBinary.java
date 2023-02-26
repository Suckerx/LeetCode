package SwordForOfferTwo.day01;

import java.util.Deque;
import java.util.LinkedList;

//剑指 Offer II 002. 二进制加法
public class AddBinary {

    //暴力枚举
    public String addBinary(String a, String b) {
        int sum = 0;
        int size = a.length() - b.length();
        if(size > 0){
            for (int i = 0; i < size; i++) b = "0" + b;
        }
        else for (int i = 0; i < Math.abs(size); i++) a = "0" + a;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        Deque<Character> queue = new LinkedList<>();
        for (int i = charA.length - 1; i >= 0 ; i--) {
            if(sum > 0){
                if(charA[i] == '0' && charB[i] == '0'){
                    queue.offerFirst('1');
                    sum--;
                }
                else if(charA[i] == '1' && charB[i] == '1') queue.offerFirst('1');
                else queue.offerFirst('0');
            }else{
                if(charA[i] == '1' && charB[i] == '1'){
                    queue.offerFirst('0');
                    sum++;
                }
                else if(charA[i] == '0' && charB[i] == '0') queue.offerFirst('0');
                else queue.offerFirst('1');
            }
        }
        if(sum > 0){
            for (int i = 0; i < sum; i++) {
                queue.offerFirst('1');
            }
        }
        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()){
            str.append(queue.pollFirst());
        }
        return str.toString();
    }

}
