package SwordForOfferTwo.day26;

//剑指 Offer II 076. 数组中的第 k 大的数字
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length - 1);
        return nums[nums.length - k];
    }

    public void quickSort(int[] nums,int l,int r){
        if(l < r){
            swap(nums,l + (int) Math.random() * (r - l + 1),r);
            int[] temp = partition(nums,l,r);
            quickSort(nums,l,temp[0] - 1);
            quickSort(nums,temp[1] + 1,r);
        }
    }

    public int[] partition(int[] nums,int L,int R){
        int less = L - 1;
        int more = R;
        while(L < more){
            if(nums[L] < nums[R]) swap(nums,++less,L++);
            else if(nums[L] > nums[R]) swap(nums,--more,L);
            else L++;
        }
        swap(nums,more,R);
        return new int[]{less + 1,more};
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
