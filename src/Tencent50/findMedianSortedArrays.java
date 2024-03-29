package Tencent50;

//4. 寻找两个正序数组的中位数
public class findMedianSortedArrays {

    //二分法，合并奇偶两种情况
    //https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/8999/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/?orderBy=hot
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //合并两种情况，奇数和偶数，如果是奇数left = right
        return (getKth(nums1,0,n - 1,nums2,0,m-1,left) + getKth(nums2,0,m - 1,nums1,0,n-1,right)) * 0.5;
    }

    public int getKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if(len1 > len2) return getKth(nums2,start2,end2,nums1,start1,end1,k);
        if(len1 == 0) return nums2[start2 + k - 1];
        if(k == 1) return Math.min(nums1[start1],nums2[start2]);

        int i = start1 + Math.min(len1,k / 2) - 1;
        int j = start2 + Math.min(len2,k / 2) - 1;

        if(nums1[i] > nums2[j]){
            return getKth(nums1,start1,end1,nums2,j + 1,end2,k - (j - start2 + 1));
        }
        else{
            return getKth(nums1,i+1,end1,nums2,start2,end2,k - (i - start1 + 1));
        }
    }

}
