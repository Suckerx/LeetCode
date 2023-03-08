package SwordForOfferTwo.day08;

//剑指 Offer II 024. 反转链表
public class ReverseList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        return recur(head,null);
    }

    public ListNode recur(ListNode cur,ListNode pre){
        if(cur == null) return pre;
        ListNode res = recur(cur.next,cur);
        cur.next = pre;
        return res;
    }

}
