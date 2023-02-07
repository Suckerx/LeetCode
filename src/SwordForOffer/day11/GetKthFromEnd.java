package SwordForOffer.day11;

//剑指 Offer 22. 链表中倒数第k个节点
public class GetKthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }
        while(cur!=null){
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }

}
