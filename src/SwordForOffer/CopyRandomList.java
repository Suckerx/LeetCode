package SwordForOffer;

import java.util.HashMap;

//剑指 Offer 35. 复杂链表的复制
public class CopyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //题解1：使用递归+哈希表来存储当前节点和对应的新节点
    //注意：random对应的节点在遍历的时候，可能还没创建，所以不好直接遍历复制
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {

        if(head==null) return null;

        if(!map.containsKey(head)){
            Node newNode = new Node(head.val);
            map.put(head,newNode);
            newNode.next = copyRandomList(head.next);
            newNode.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    //注意到方法一需要使用哈希表记录每一个节点对应新节点的创建情况，而我们可以使用一个小技巧来省去哈希表的空间。
    //我们首先将该链表中每一个节点拆分为两个相连的节点，例如对于链表 A→B→C，我们可以将其拆分为A→A′→B→B′→C→C′
    //对于任意一个原节点 S，其拷贝节点 S′即为其后继节点。
    public Node copyRandomList2(Node head) {

        if(head==null) return null;

        for(Node node = head;node!=null;node = node.next.next){
            Node newNode = new Node(head.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        for(Node node = head;node!=null;node = node.next.next){
            Node newNode = node.next;
            newNode.random = (node.random != null) ? node.random.next : null;
        }
        Node newHead = head.next;
        for(Node node = head;node!=null;node = node.next.next){
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = (newNode.next != null) ? newNode.next.next : null;
        }

        return newHead;
    }

}
