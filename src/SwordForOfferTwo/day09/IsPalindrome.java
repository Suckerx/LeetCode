package SwordForOfferTwo.day09;

import java.util.Stack;

//剑指 Offer II 027. 回文链表
public class IsPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node!=null){
            stack.push(node);
            node = node.next;
        }
        while(!stack.isEmpty()){
            if(head.val!=stack.pop().val) return false;
            head = head.next;
        }
        return true;
    }

    //快慢指针实现空间复杂度O(1)
    public boolean isPalindrome2(ListNode head) {
        if(head.next == null) return true;
        ListNode fast = head,slow = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;
        ListNode pre = null,cur = null;
        while(slow != null){
            cur = slow.next;
            slow.next = pre;
            pre = slow;
            slow = cur;
        }
        while(pre!=null){
            if(pre.val != head.val) return false;
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1,null);
        node.next = new ListNode(1,new ListNode(2,new ListNode(1,null)));
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome2(node));
    }

}
