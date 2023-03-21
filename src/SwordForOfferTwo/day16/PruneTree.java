package SwordForOfferTwo.day16;

//剑指 Offer II 047. 二叉树剪枝
public class PruneTree {

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

    /**
     * 树相关的题目首先考虑用递归解决。首先确定边界条件，当输入为空时，即可返回空。
     * 然后对左子树和右子树分别递归进行 pruneTree 操作。
     * 递归完成后，当这三个条件：左子树为空，右子树为空，当前节点的值为 ，
     * 同时满足时，才表示以当前节点为根的原二叉树的所有节点都为 0，需要将这棵子树移除，返回空。
     * 有任一条件不满足时，当前节点不应该移除，返回当前节点。
     */
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }

}
