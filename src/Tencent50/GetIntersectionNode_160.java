package Tencent50;

//160. 相交链表
public class GetIntersectionNode_160 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int sizeA = 0,sizeB = 0;
        ListNode nodeA = headA,nodeB = headB;
        while(nodeA != null){
            nodeA = nodeA.next;
            sizeA++;
        }
        while(nodeB != null){
            nodeB = nodeB.next;
            sizeB++;
        }
        nodeA = headA;
        nodeB = headB;
        if(sizeA > sizeB){
            for (int i = 0; i < Math.abs(sizeA - sizeB); i++) {
                nodeA = nodeA.next;
            }
        }
        else if(sizeA < sizeB){
            for (int i = 0; i < Math.abs(sizeA - sizeB); i++) {
                nodeB = nodeB.next;
            }
        }
        if(nodeA == nodeB) return nodeA;
        while(nodeA != nodeB && nodeA != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            if(nodeA == nodeB) return nodeA;
        }
        return null;
    }

}
