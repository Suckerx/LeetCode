package SwordForOfferTwo.day16;

//剑指 Offer II 049. 从根节点到叶节点的路径数字之和
public class SumNumbers {

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

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root,"");
        return sum;
    }

    public TreeNode dfs(TreeNode root ,String str){
        if(root == null) return null;
        root.left = dfs(root.left,str + root.val);
        root.right = dfs(root.right,str + root.val);
        if(root.left == null && root.right == null){
            sum += Integer.valueOf(str + root.val);
        }
        return root;
    }

}
