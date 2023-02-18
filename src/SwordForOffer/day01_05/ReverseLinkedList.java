package SwordForOffer.day01_05;

//剑指 Offer 24. 反转链表
public class ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if(head==null)return null;
        ListNode pre = head;
        ListNode preNext = head;
        ListNode right = head.next;
        head.next = null;

        while(right!=null){
            preNext = right;
            right = right.next;
            preNext.next=pre;
            pre = preNext;
        }

        return pre;
    }

}
