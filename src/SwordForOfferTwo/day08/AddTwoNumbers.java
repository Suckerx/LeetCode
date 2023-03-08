package SwordForOfferTwo.day08;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

//剑指 Offer II 025. 链表中的两数相加
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode head = new ListNode(0, null);
        boolean x = false;
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        if(stack1.peek() + stack2.peek()  > 9) x = true;
        head.val = (stack1.pop() + stack2.pop()) % 10;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int val = x == true ? (stack1.peek() + stack2.peek() + 1) % 10 : (stack1.peek() + stack2.peek()) % 10;
            if(x == true){
                if(stack1.pop() + stack2.pop() + 1 < 10) x = false;
            }
            else{
                if(stack1.pop() + stack2.pop() >= 10) x = true;
            }
            ListNode node = new ListNode(val, head);
            head = node;
        }
        while(!stack1.isEmpty()){
            if(x){
                if(stack1.peek() + 1 < 10) x = false;
                ListNode node = new ListNode((stack1.pop() + 1) % 10, head);
                head = node;
            }
            else {
                ListNode node = new ListNode(stack1.pop(), head);
                head = node;
            }
        }
        while(!stack2.isEmpty()){
            if(x){
                if(stack2.peek() + 1 < 10) x = false;
                ListNode node = new ListNode((stack2.pop() + 1) % 10, head);
                head = node;
            }
            else {
                ListNode node = new ListNode(stack2.pop(), head);
                head = node;
            }
        }
        if(x) return new ListNode(1,head);
        return head;
    }

    //简洁版代码
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(12 / 10);
    }

}
