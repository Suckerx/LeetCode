package SwordForOfferTwo.day24;

//剑指 Offer II 073. 狒狒吃香蕉
public class MinEatingSpeed {

    //https://leetcode.cn/problems/nZZqjQ/solutions/1537915/fei-fei-chi-xiang-jiao-by-leetcode-solut-0jge/
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right,pile);
        }
        int res = right;
        while(left < right){
            int speed = left + (right - left) / 2;
            long time = getTime(piles,speed);
            if(time <= h){
                res = speed;
                right = speed;
            }
            else left = speed + 1;
        }
        return res;
    }

    public long getTime(int[] piles,int speed){
        long time = 0;
        for (int pile : piles) {
            time += (speed + pile - 1) / speed;
        }
        return time;
    }

}
