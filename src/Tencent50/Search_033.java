package Tencent50;

//33. 搜索旋转排序数组
public class Search_033 {

    //https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/220083/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/?orderBy=hot
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else left = mid + 1;
            }
            else{
                if(nums[mid] < target && target <= nums[n - 1]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

}
