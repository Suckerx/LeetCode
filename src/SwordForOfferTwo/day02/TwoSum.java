package SwordForOfferTwo.day02;

import java.util.Arrays;
import java.util.HashMap;

//剑指 Offer II 006. 排序数组中两个数字之和
public class TwoSum {

    //还可以使用双指针
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i],i);
            if(map.containsKey(target - numbers[i]) && (i != map.get(target - numbers[i])) )
                return Arrays.stream(new int[]{map.get(numbers[i]),map.get(target - numbers[i])}).sorted().toArray();
            else if( map.containsKey(target - numbers[i]) && (i == map.get(target - numbers[i])) ){
                if( i >0 && numbers[i] + numbers[i-1] == target) return new int[]{i-1,i};
                if(i+1 != numbers.length && numbers[i] + numbers[i+1] == target) return new int[]{i,i+1};
            }
        }
        return new int[]{0,1};
    }

}
