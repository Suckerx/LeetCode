package Tencent50;

//141. 环形链表
public class HasCycle_141 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return false;
        ListNode slow = head,fast = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
            if(fast == slow) return true;
        }
        return false;
    }

}
