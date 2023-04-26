package Tencent50;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import sun.nio.cs.ext.MacHebrew;

//124. 二叉树中的最大路径和
public class MaxPathSum_124 {

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

    //https://leetcode.cn/problems/binary-tree-maximum-path-sum/solutions/297005/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/?orderBy=hot&languageTags=java

    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(maxGain(root.left),0);
        int right = Math.max(maxGain(root.right),0);

        int priceNewPath = root.val + left + right;
        if(maxSum < priceNewPath) maxSum = priceNewPath;

        return root.val + Math.max(left,right);
    }

}
