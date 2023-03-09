package SwordForOfferTwo.day09;

//剑指 Offer II 029. 排序的循环链表
public class Insert {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    //一次遍历解法
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        if(head.next == head){
            head.next = new Node(insertVal,head);
            return head;
        }
        boolean x = false;
        Node cur = head,next = head.next;
        while(next != head){
            if((cur.val <= insertVal && insertVal <= next.val) || ((cur.val < insertVal || insertVal < next.val) && cur.val > next.val) ){
                cur.next = new Node(insertVal,next);
                x = true;
                break;
            }
            cur = cur.next;
            next = next.next;
        }
        if(!x) cur.next = new Node(insertVal,next);
        return head;
    }

}
