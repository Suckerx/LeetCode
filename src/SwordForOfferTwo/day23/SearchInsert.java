package SwordForOfferTwo.day23;

//剑指 Offer II 068. 查找插入位置
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = left + (right - left) / 2 ;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return left;
    }

}
