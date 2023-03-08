package SwordForOfferTwo.day07;

//剑指 Offer II 023. 两个链表的第一个重合节点
public class GetIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int sizeA = 0,sizeB = 0;
        ListNode nodeA = headA,nodeB = headB;
        while(nodeA != null){
            sizeA++;
            nodeA = nodeA.next;
        }
        while(nodeB != null){
            sizeB++;
            nodeB = nodeB.next;
        }
        int len = Math.abs(sizeA - sizeB);
        if(sizeA > sizeB) for (int i = 0; i < len; i++) headA = headA.next;
        else if(sizeA < sizeB) for (int i = 0; i < len; i++) headB = headB.next;
        while(headA != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

}
