package SwordForOfferTwo.day25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指 Offer II 074. 合并区间
public class Merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0],R = intervals[i][1];
            if(res.size() == 0 || res.get(res.size() - 1)[1] < L) res.add(new int[]{L,R});
            else res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1] , R);
        }
        return res.toArray(new int[res.size()][]);
    }

}
