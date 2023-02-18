package SwordForOffer.day15;

import java.util.Deque;
import java.util.LinkedList;

//剑指 Offer 54. 二叉搜索树的第k大节点
public class KthLargest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Deque<TreeNode> queue = new LinkedList<>();

    public int kthLargest(TreeNode root, int k) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        dfs(root);
        TreeNode res = null;
        while(k!=0){
            res = queue.pollLast();
            k--;
        }
        return res.val;
    }

    void dfs(TreeNode cur) {
        if(cur == null) return;
        dfs(cur.left);
        queue.offer(cur);
        dfs(cur.right);
    }

}
