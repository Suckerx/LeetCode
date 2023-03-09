package SwordForOfferTwo.day10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

//剑指 Offer II 030. 插入、删除和随机访问都是 O(1) 的容器
public class RandomizedSet {

    HashSet<Integer> set;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.contains(val)) return false;
        set.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!set.contains(val)) return false;
        set.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int[] ints = set.stream().mapToInt(Integer::valueOf).toArray();
        return ints[new Random().nextInt(ints.length)];
    }

}
