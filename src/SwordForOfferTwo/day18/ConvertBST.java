package SwordForOfferTwo.day18;

import java.util.Deque;
import java.util.LinkedList;

//剑指 Offer II 054. 所有大于等于节点的值之和
public class ConvertBST {

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

    Deque<TreeNode> deque = new LinkedList<>();

    public TreeNode convertBST(TreeNode root) {
        if(root == null ) return null;
        if(root.right == null && root.left == null) return root;
        process(root);
        int sum = 0;
        while(!deque.isEmpty()){
            sum += deque.peekLast().val;
            deque.pollLast().val = sum;
        }
        return root;
    }

    public void process(TreeNode root){
        if(root == null) return ;
        process(root.left);
        deque.offerLast(root);
        process(root.right);
    }

}
