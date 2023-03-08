package SwordForOfferTwo.day07;

//剑指 Offer II 022. 链表中环的入口节点
public class DetectCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //双指针，两轮相遇
    //https://leetcode.cn/problems/c32eOV/solutions/977000/jian-zhi-offer-ii-022-lian-biao-zhong-hu-8f1m/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while(true){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
