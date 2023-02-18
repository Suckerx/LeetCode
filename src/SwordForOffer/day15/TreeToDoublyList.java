package SwordForOffer.day15;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//剑指 Offer 36. 二叉搜索树与双向链表
public class TreeToDoublyList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    //使用中序遍历，先把左节点全部压栈，然后每弹出一个就把右节点压栈
    //出栈操作后，把节点放入双端队列中，最后得到排序的双端队列
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;

        Stack<Node> stack1 = new Stack<>();
        Deque<Node> queue = new LinkedList<>();
        while(!stack1.isEmpty() || root != null){
            if(root != null){
                stack1.push(root);
                root = root.left;
            }
            else{
                root = stack1.pop();
                queue.add(root);
                root = root.right;
            }
        }

        Node last = queue.peekLast();
        Node first = queue.peekFirst();
        first.left = last;
        last.right = first;

        last = queue.pollLast();
        while(!queue.isEmpty()){
            first = queue.pollLast();
            first.right = last;
            last.left = first;
            last = first;
        }
        return last;
    }


    //中序遍历直接操作，两个节点表示前驱和后继，中序遍历的打印操作改为修改指针指向
    /**
     * 根据以上分析，考虑使用中序遍历访问树的各节点 cur ；并在访问每个节点时构建 cur 和前驱节点 pre 的引用指向；
     * 中序遍历完成后，最后构建头节点和尾节点的引用指向即可。
     */
    Node pre, head;
    public Node treeToDoublyList2(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }



}
