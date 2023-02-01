package SwordForOffer;

import javax.xml.bind.annotation.XmlID;

//剑指 Offer 11. 旋转数组的最小数字
public class MinArray {

    // 二分判断，三种情况
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            int mid = left + (right-left) / 2;
            if(numbers[mid] < numbers[right]) right = mid;
            else if(numbers[mid] > numbers[right] ) left = mid +1;
            else right--;
        }
        return numbers[left];
    }

}
