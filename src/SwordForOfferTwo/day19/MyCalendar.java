package SwordForOfferTwo.day19;

import java.util.TreeMap;

//剑指 Offer II 058. 日程表
public class MyCalendar {

    TreeMap<Integer,Integer> map;

    public MyCalendar() {
        this.map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(map.containsKey(start)) return false;
        if(map.ceilingKey(start) != null && end > map.ceilingKey(start)) return false;
        if(map.floorKey(start) != null && map.get(map.ceilingKey(start)) > start) return false;
        map.put(start,end);
        return true;
    }

}
