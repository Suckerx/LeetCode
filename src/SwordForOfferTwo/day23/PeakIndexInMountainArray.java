package SwordForOfferTwo.day23;

import java.util.Arrays;

//剑指 Offer II 069. 山峰数组的顶部
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 3) return 1;//当数组长度为3，下面代码会越界
        int left = 0;
        //肯定不是最后一个
        int right = arr.length - 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            else if(arr[mid] > arr[mid + 1]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

}
