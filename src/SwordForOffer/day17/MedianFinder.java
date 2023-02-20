package SwordForOffer.day17;

import java.util.*;

//剑指 Offer 41. 数据流中的中位数
public class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Integer[] a = new Integer[list.size()];
        a = list.toArray(a);
        Arrays.sort(a);
        List<Integer> b = Arrays.asList(a);
        list = new ArrayList<>(b);
    }

    public double findMedian() {
        int size = list.size();
        if(size == 1) return (double) list.get(0);
        return size%2 == 1 ? (double) list.get(size/2) : ((list.get(size/2) + list.get(size/2 - 1))/2.0 );
    }

    /**
     * 解题思路：
     * 给定一长度为 NNN 的无序数组，其中位数的计算方法：
     * 首先对数组执行排序（使用 O(NlogN)时间），
     * 然后返回中间元素即可（使用 O(1)时间）。
     *
     * 针对本题，根据以上思路，可以将数据流保存在一个列表中，并在添加元素时 保持数组有序 。
     * 此方法的时间复杂度为 O(N)，其中包括： 查找元素插入位置 O(logN)（二分查找）、向数组某位置插入元素 O(N)
     * （插入位置之后的元素都需要向后移动一位）。
     *
     * 借助 堆 可进一步优化时间复杂度。
     *
     * 建立一个 小顶堆 A 和 大顶堆 B ，各保存列表的一半元素，且规定：
     * A 保存 较大 的一半，长度为 N/2（ N 为偶数）或 (N+1)/2（ N 为奇数）
     * B 保存 较小 的一半，长度为 N/2（ N 为偶数）或 (N-1)/2（ N 为奇数）
     * 随后，中位数可仅根据 A,BA, BA,B 的堆顶元素计算得到
     *
     * 算法流程：
     * 设元素总数为 N=m+n ，其中 m 和 n 分别为 A 和 B 中的元素个数。
     * 当 m=n（即 N 为 偶数）：需向 A 添加一个元素。实现方法：将新元素 num插入至 B ，再将 B 堆顶元素插入至 A ；
     * 当 m≠n（即 N 为 奇数）：需向 B 添加一个元素。实现方法：将新元素 num 插入至 A ，再将 A 堆顶元素插入至 B ；
     * 假设插入数字 num 遇到情况 1. 。由于 num 可能属于 “较小的一半” （即属于 B ），
     * 因此不能将 nums直接插入至 A 。而应先将 num 插入至 B ，再将 B 堆顶元素插入至 A 。
     * 这样就可以始终保持 A 保存较大一半、 B 保存较小一半。
     *
     */


    Queue<Integer> A,B;
    public void MedianFinder2() {
        A = new PriorityQueue<Integer>();// 小顶堆，保存较大的一半
        B = new PriorityQueue<Integer>((x,y)-> (y-x));// 大顶堆，保存较小的一半
    }

    public void addNum2(int num) {
        if(A.size() != B.size()){
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian2() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek())/2.0;
    }

}
