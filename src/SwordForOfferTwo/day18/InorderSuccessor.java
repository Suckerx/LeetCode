package SwordForOfferTwo.day18;

import java.util.*;

//剑指 Offer II 053. 二叉搜索树中的中序后继
public class InorderSuccessor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Deque<TreeNode> deque = new LinkedList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        process(root);
        while(!deque.isEmpty()){
            if(deque.peekFirst() == p && deque.size() > 1){
                deque.pollFirst();
                return deque.pollFirst();
            }
            deque.pollFirst();
        }
        return null;
    }

    public void process(TreeNode root){
        if(root == null) return ;
        process(root.left);
        deque.offerLast(root);
        process(root.right);
    }

}
