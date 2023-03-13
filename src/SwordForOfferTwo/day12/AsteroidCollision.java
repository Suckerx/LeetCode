package SwordForOfferTwo.day12;

import java.util.*;

//剑指 Offer II 037. 小行星碰撞
public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] > 0) stack1.offerLast(asteroids[i]);
            else{
                if(stack1.isEmpty()) stack2.offerLast(asteroids[i]);
                else{
                    while (!stack1.isEmpty() && stack1.peekLast() < Math.abs(asteroids[i])) stack1.pollLast();
                    if(!stack1.isEmpty() && stack1.peekLast() == Math.abs(asteroids[i])){
                        stack1.pollLast();
                        continue;
                    }
                    if(stack1.isEmpty()) stack2.offerLast(asteroids[i]);
                }
            }
        }
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            while(!stack2.isEmpty()) list.add(stack2.pollFirst());
            while(!stack1.isEmpty()) list.add(stack1.pollFirst());
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

}
