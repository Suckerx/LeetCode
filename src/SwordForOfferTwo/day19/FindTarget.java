package SwordForOfferTwo.day19;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//剑指 Offer II 056. 二叉搜索树中两个节点之和
public class FindTarget {

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

    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        process(root);
        for (int num : set) {
            if(set.contains(k - num) && k-num != k) return true;
        }
        return false;
    }

    public void process(TreeNode root){
        if(root == null) return ;
        process(root.left);
        set.add(root.val);
        process(root.right);
    }



}
