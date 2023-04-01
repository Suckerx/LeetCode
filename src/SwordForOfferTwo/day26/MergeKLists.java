package SwordForOfferTwo.day26;

//剑指 Offer II 078. 合并排序链表
public class MergeKLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode temp = new ListNode(-1);
        ListNode head = temp;
        for (ListNode list : lists) {
            temp.next = list;
            while(temp.next != null) temp = temp.next;
        }
        return sortedList(head.next,null);
    }

    public ListNode sortedList(ListNode head,ListNode tail){
        if(head == null) return head;
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail) fast = fast.next;
        }
        ListNode mid = slow;
        ListNode list1 = sortedList(head,mid);
        ListNode list2 = sortedList(mid,tail);
        ListNode sorted = mearge(list1,list2);
        return sorted;
    }

    public ListNode mearge(ListNode head1,ListNode head2){
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1 = head1,temp2 = head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1!=null) temp.next = temp1;
        else if(temp2!=null) temp.next = temp2;
        return dummyHead.next;
    }


    //归并简化：
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mearge2(ans,lists[i]);
        }
        return ans;
    }

    public ListNode mearge2(ListNode head1,ListNode head2){
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead,temp1 = head1,temp2 = head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp.next = temp1 != null ? temp1 : temp2;
        return dummyHead.next;
    }

}
