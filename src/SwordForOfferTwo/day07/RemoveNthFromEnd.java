package SwordForOfferTwo.day07;

//剑指 Offer II 021. 删除链表的倒数第 n 个结点
public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode pre = null,cur = head,next = head;
        boolean x = false;
        while((n--)-1 != 0) next = next.next;
        while(next.next != null){
            x = true;
            pre = cur;
            cur = cur.next;
            next = next.next;
        }
        next = cur.next;
        cur.next = null;
        if(pre!=null) pre.next = next;
        return x ? head : next;
    }

}
