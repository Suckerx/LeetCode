package SwordForOffer.day07;

import sun.reflect.generics.tree.Tree;

//剑指 Offer 28. 对称的二叉树
public class IsSymmetric {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //弱智解法：判断二叉树的镜像是否相同，相同则是对称的
    public boolean isSymmetric(TreeNode root) {
        TreeNode node = clone(root);
        node = mirrorTree(node);
        return isSameTree(root,node);
    }

    public TreeNode clone(TreeNode root){
        TreeNode node = null;
        if(root == null) return null;
        node = new TreeNode(root.val);
        clone(root.left);
        clone(root.right);
        return node;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }
        if (t1.val != t2.val){
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    //解法二：
    public boolean isSymmetric2(TreeNode root) {
        return root == null ? true : recur(root.left,root.right);
    }

    public boolean recur(TreeNode root,TreeNode node){
        if(root == null && node == null) return true;
        if(root!= null || node != null) return false;
        if(root.left.val != node.right.val) return false;
        return recur(root.left,node.right) && recur(root.right,node.left);
    }


}
