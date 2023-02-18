package SwordForOffer.day01_05;

//剑指 Offer 06. 从尾到头打印链表
public class PrintLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        int[] a = new int[10000];
        int i=0;
        int t=0;

        while (head!=null){
            a[i++] = head.val;
            head = head.next;
        }

        int[] result = new int[i];
        for (int j = i-1; j >=0 ; j--) {
            result[t++] = a[j];
        }
        return result;
    }

}
