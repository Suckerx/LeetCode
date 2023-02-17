package SwordForOffer.day12;

//剑指 Offer 25. 合并两个排序的链表
public class MergeTwoLists {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

      //迭代法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);
        ListNode pre = newList;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return newList.next;
    }

    //递归法
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }


}
