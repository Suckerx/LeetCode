package SwordForOfferTwo.day09;

import java.util.List;

//剑指 Offer II 028. 展平多级双向链表
public class Flatten {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    //DFS
    public Node flatten(Node head) {
        if(head == null) return null;
        dfs(head);
        return head;
    }

    public Node dfs(Node cur){// 返回当前层的最后一个节点
        Node last = cur;
        while(cur!=null){
            Node next = cur.next;// 记录next方便更新next
            if(cur.child != null){
                Node childLast = dfs(cur.child); // 递归获取child层的最后一个节点
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                if(next != null){
                    childLast.next = next;
                    next.prev = childLast;
                }
                last = childLast; // last 更新为child层的最后一个节点，因为不知道next是否为空，而childLast是当前已知的最后一个节点
            }else last = cur;
            cur = next;
        }
        return last;
    }

}
