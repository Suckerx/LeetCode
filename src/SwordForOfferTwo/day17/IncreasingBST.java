package SwordForOfferTwo.day17;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//剑指 Offer II 052. 展平二叉搜索树
public class IncreasingBST {

    public class TreeNode {
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

    private Deque<TreeNode> deque = new LinkedList<>();

    public TreeNode increasingBST(TreeNode root) {
        process(root);
        TreeNode node = deque.peekFirst();
        while(deque.size() > 1){
            TreeNode treeNode = deque.pollFirst();
            treeNode.left = null;
            treeNode.right = deque.peekFirst();
        }
        deque.peekFirst().left = null;
        deque.peekFirst().right = null;
        return node;
    }

    public void process(TreeNode root){
        if(root == null) return;
        process(root.left);
        deque.offerLast(root);
        process(root.right);
        return ;
    }

}
