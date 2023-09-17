package Tencent50;

import java.util.PriorityQueue;
import java.util.Random;

//215. 数组中的第K个最大元素
public class FindKthLargest_215 {

    /**
     * Partition Function 的主要作用是将数组 a 中的元素按照某个标准分为两部分，使得左边的元素均小于等于某个基准元素（pivot），右边的元素均大于等于该基准元素。这个基准元素可以是数组中的任意一个元素，通常选择最后一个元素作为基准元素。
     *
     * 代码中，l 和 r 分别表示待分区数组的左右边界（左闭右闭），x 表示基准元素，初始值设为 a[r]。i 为分割点，初始值为 l - 1。
     *
     * 从 l 到 r - 1 遍历待分区数组，若当前元素 a[j] 小于等于基准元素 x，则将 a[j] 与 a[i+1] 交换，并将 i 的值加一。这样就可以保证分割点 i 左边的元素都小于等于 x，右边的元素都大于等于 x。最后再将分割点 i+1 处的元素与基准元素 a[r] 交换，这样就完成了一次分区。
     *
     * 该函数的返回值是分割点的下标 i+1，可以将该下标作为递归调用快速排序函数时的分割点，将原数组分为左右两个子数组。
     */
    //https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/?orderBy=hot

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length - 1,nums.length - k);
    }

    public int quickSelect(int[] nums,int l,int r,int index){
        int q = randomPartition(nums,l,r);
        if(q == index) return nums[q];
        else{
            return q < index ? quickSelect(nums,q+1,r,index) : quickSelect(nums,l,q-1,index);
        }
    }

    public int randomPartition(int[] nums,int l,int r){
        int i = random.nextInt(r - l + 1) + l;
        swap(nums,i,r);
        return partition(nums,l,r);
    }

    public int partition(int[] nums, int l, int r){
        int x = nums[r],i = l - 1;
        for (int j = l; j < r; j++) {
            if(nums[j] <= x){
                swap(nums,++i,j);
            }
        }
        swap(nums,i+1,r);
        return i+1;
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //优先队列
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }

}
