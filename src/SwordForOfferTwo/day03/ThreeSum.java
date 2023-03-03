package SwordForOfferTwo.day03;

import java.util.*;

//剑指 Offer II 007. 数组中和为 0 的三个数
public class ThreeSum {

    //排序 + 双指针 + 哈希表去重
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1 ,right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0) right --;
                else if(sum < 0) left ++;
                else{
                    if(left >= right) break;
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    Collections.sort(list);
                    set.add(list);
                    while(left<right&&nums[left]==nums[++left]);
                    while(left<right&&nums[right]==nums[--right]);
                }
            }
        }
        return new ArrayList<>(set);
    }

}
