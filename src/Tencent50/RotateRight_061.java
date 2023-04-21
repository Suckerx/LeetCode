package Tencent50;

import java.util.HashMap;

//61. 旋转链表
public class RotateRight_061 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //闭合为环
    //https://leetcode.cn/problems/rotate-list/solutions/681812/xuan-zhuan-lian-biao-by-leetcode-solutio-woq1/?orderBy=hot
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        int num = 1;
        ListNode first = head;
        while(first != null){
            num++;
            first = first.next;
        }
        num -= 1;
        k = num - k % num;
        if(k == num) return head;

        first = new ListNode(-1);
        first.next = head;
        while(k-- > 0){
            first = first.next;
        }
        ListNode res = first.next;
        first.next = null;
        return res;
    }

    public static void main(String[] args) {
        RotateRight_061 ro = new RotateRight_061();
        ListNode listNode = new ListNode(0, new ListNode(1, new ListNode(2, null)));
        ro.rotateRight(listNode,4);
    }

}
