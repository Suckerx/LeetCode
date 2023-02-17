package SwordForOffer.day13;

//剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
public class Exchange {

    //原地双指针交换
    public int[] exchange(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return nums;
        int cur = 0,next = 1;

        while(next != nums.length){
            if(nums[cur] % 2 == 1){
                cur++;
                next++;
            }
            else{
                if(nums[next] % 2 == 1){
                    int temp = nums[cur];
                    nums[cur] = nums[next];
                    nums[next] = temp;
                }
                else next++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,1,2};
        System.out.println(a[0]%2);
    }

}
