package SwordForOfferTwo.day14;

//剑指 Offer II 043. 往完全二叉树添加节点

import java.util.Deque;
import java.util.LinkedList;

public class CBTInserter {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private TreeNode root;
    private Deque<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
    }

    public int insert(int v) {
        TreeNode treeNode = new TreeNode(v);
        TreeNode node = root;
        queue.offerLast(node);
        while(!queue.isEmpty() && queue.peekFirst().left != null && queue.peekFirst().right != null){
            TreeNode right = queue.peek().right;
            TreeNode left = queue.peek().left;
            queue.pollFirst();
            queue.offerLast(left);
            queue.offerLast(right);
        }
        if(queue.peek().left == null){
            queue.peek().left = treeNode;
            return queue.peek().val;
        }else queue.peek().right = treeNode;
        return queue.peek().val;
    }

    public TreeNode get_root() {
        return root;
    }

}
