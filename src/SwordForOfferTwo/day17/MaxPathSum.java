package SwordForOfferTwo.day17;

//剑指 Offer II 051. 节点之和最大的路径
public class MaxPathSum {

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

    //https://leetcode.cn/problems/jC7MId/solutions/1656737/by-fen-zi-yun-he-aaj5/
    //后序遍历

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 当前节点 单独组成的路径
        res = Math.max(res, root.val);
        // 左+当前+右 组成的路径
        res = Math.max(res, left + root.val + right);
        // 左+当前
        res = Math.max(res, left + root.val);
        // 当前+右
        res = Math.max(res, root.val + right);

        // 返回最大值，由于一个节点只能在路径中出现一次
        // 所以要么返回当前节点的值，要么返回 当前+左，要么返回 当前+右
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
    }

}
