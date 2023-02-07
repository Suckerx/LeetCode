package SwordForOffer.day11;

//剑指 Offer 18. 删除链表的节点
public class DeleteNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(val == head.val) return head.next;
        ListNode pre = head , cur = head.next;
        while (cur != null){
            if(cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }

}
