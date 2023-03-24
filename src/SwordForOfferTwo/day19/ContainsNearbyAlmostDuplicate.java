package SwordForOfferTwo.day19;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//剑指 Offer II 057. 值和下标之差都在给定的范围内
public class ContainsNearbyAlmostDuplicate {

    //方法一：滑动窗口 + 有序集合
    //https://leetcode.cn/problems/7WqeDu/solutions/1038291/zhi-he-xia-biao-zhi-chai-du-zai-gei-ding-94ei/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long celing = set.ceiling((long) nums[i] - (long) t);
            if(celing != null && celing <= (long) nums[i] + (long) t) return true;
            set.add((long) nums[i]);
            if(i >= k) set.remove((long) nums[i-k]);
        }
        return false;
    }

    //桶排序
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int n = nums.length;

        //桶的大小为t+1，允许最大元素和最小元素之差为t
        long w = (long) t + 1;

        //因为一个桶有两个元素就会返回true，因此一个桶只有一个元素，可以用哈希表的一条key-value表示桶
        Map<Long, Long> map = new HashMap<Long, Long>();

        for (int i = 0; i < n; i++) {
            long id = getID(nums[i], w);

            //桶里已有元素x，nums[i]和x同属一个桶，值符合范围
            //只保留下标 i 之前的 k 个元素，因此下标也符合范围
            //桶有两个元素就会返回，因此一个桶只有一个元素
            if (map.containsKey(id)) {
                return true;
            }

            //前一个桶有一个元素，并且值的范围符合要求
            if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
                return true;
            }

            //后一个桶有一个元素，并且值的范围符合要求
            if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
                return true;
            }

            //没有和nums[i]匹配的元素，把nums[i]加入自己的桶里
            map.put(id, (long) nums[i]);

            //下标范围[i-k+1, i]，从nums[i-k]所在桶移除元素
            if (i >= k) {
                map.remove(getID(nums[i - k], w));
            }
        }
        return false;
    }

    public long getID(long x, long w) {
        //非负数区间，如[0, t] 会被归到 id=0
        //其余的区间，如[(n-1)t+1, nt+1]，每t+1个元素会被归到 id = n-1
        if (x >= 0) {
            return x / w;
        }

        //负数区间，如[-t, -1] 会被归到 id=-1
        //其余的区间，如[-(n+1)t-1, -nt-1]，每t+1个元素会被归到 id = -(n+1)
        return (x + 1) / w - 1;
    }

}
