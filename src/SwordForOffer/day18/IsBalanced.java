package SwordForOffer.day18;

//剑指 Offer 55 - II. 平衡二叉树
public class IsBalanced {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //自顶向下
    //递归得到左右子树深度差，比较是否等于1，在每个子树上重复操作，时间复杂度较高
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        return 1+Math.max(dfs(root.left),dfs(root.right));
    }


    //自底向上
    //后续遍历 + 剪枝
    /**
     * 思路是对二叉树做后序遍历，从底至顶返回子树深度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
     */
    public boolean isBalanced2(TreeNode root) {
        return recur(root) != -1;
    }

    //判断左右子树的深度差

    /**
     *当节点左右子树深度差 <= 1，返回当前深度
     * 当左 (右) 子树的深度差 > 2，返回-1 ，此时到上一层，表现为left || right == -1 ，直接剪枝
     */
    public int recur(TreeNode root){
        if(root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(right-left) < 2 ? Math.max(right,left)+1 : -1;
    }

}
