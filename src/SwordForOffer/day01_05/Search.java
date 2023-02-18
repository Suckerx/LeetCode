package SwordForOffer.day01_05;

//剑指 Offer 53 - I. 在排序数组中查找数字 I
public class Search {

    public int search(int[] nums, int target) {
        int right = binarySearch(nums,target,false);//找到最右边这个数字
        int left = binarySearch(nums,target,true);//找到最左边的数字
        if(right!=nums.length && left <= right && nums[left] == target && nums[right] == target){
            return right-left+1;
        }
        return 0;
    }

    //二分加速，优化为O(logN)
    public int binarySearch(int[] nums,int target,boolean lower){
        int left = 0;
        int right = nums.length-1;
        int ans = 0;
        while(left <= right){
            int mid = (right+left) / 2;
            if(lower){
                if(nums[mid] >= target ){
                    right = mid-1;
                    ans = mid;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }
            }else{
                if(nums[mid] > target ){
                    right = mid-1;
                }else if(nums[mid] <= target){
                    left = mid + 1;
                    ans = mid;
                }
            }

        }
        return ans;
    }

}
