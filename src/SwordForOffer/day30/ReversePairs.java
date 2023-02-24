package SwordForOffer.day30;

//剑指 Offer 51. 数组中的逆序对
public class ReversePairs {

    //归并排序
    public int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        return process(nums,0,nums.length-1);
    }

    public static int process(int[] arr,int l,int r){
        if(l == r) return 0;
        int m = l + ((r - l) >> 1);
        return process(arr,l,m)+
                process(arr,m+1,r)+
                merge(arr,l,m,r);
    }

    public static int merge(int[] nums, int L, int M, int R) {
        int[] help = new int[R-L+1];
        int pair = 0;
        int p1 = L;
        int p2 = M+1;
        int i = 0;
        while (p1<= M && p2<= R) {
            if (nums[p1] > nums[p2]) {
                pair += R-p2+1;
                help[i++] = nums[p1++];
            } else {
                help[i++] = nums[p2++];
            }
        }
        while (p1<= M) {
            help[i++] = nums[p1++];
        }
        while (p2<= R) {
            help[i++] = nums[p2++];
        }
        for (int j=0; j<help.length; j++) {
            nums[L+j] = help[j];
        }
        return pair;
    }

}
