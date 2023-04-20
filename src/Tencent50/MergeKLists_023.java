package Tencent50;

//23. 合并 K 个升序链表
public class MergeKLists_023 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i++) {
            node = merge(node,lists[i]);
        }
        return node;
    }

    public ListNode merge(ListNode node1,ListNode node2){
        if(node1 == null) return node2;
        else if(node2 == null) return node1;
        if(node1.val < node2.val){
            node1.next = merge(node1.next,node2);
            return node1;
        }
        else{
            node2.next = merge(node1,node2.next);
            return node2;
        }
    }

}
