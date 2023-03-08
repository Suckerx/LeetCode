package SwordForOfferTwo.day08;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

//剑指 Offer II 026. 重排链表
public class ReorderList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        while(head != null){
            deque.offer(head);
            head = head.next;
        }
        if(deque.size() == 1) return ;
        deque.pollFirst().next = deque.peekLast();
        ListNode node = deque.pollLast();
        while(!deque.isEmpty()){
            node.next = deque.peekFirst();
            node = deque.pollFirst();
            if(deque.isEmpty()) break;
            node.next = deque.peekLast();
            node = deque.pollLast();
        }
        node.next = null;
    }

}
