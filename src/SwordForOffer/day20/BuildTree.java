package SwordForOffer.day20;

import java.util.HashMap;
import java.util.HashSet;

//剑指 Offer 07. 重建二叉树
public class BuildTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 注意：本文方法只适用于 “无重复节点值” 的二叉树。
     * 前序遍历的首元素 为 树的根节点 node 的值。
     * 在中序遍历中搜索根节点 node 的索引 ，可将 中序遍历 划分为 [ 左子树 | 根节点 | 右子树 ] 。
     * 根据中序遍历中的左（右）子树的节点数量，可将 前序遍历 划分为 [ 根节点 | 左子树 | 右子树 ] 。
     * 通过以上三步，可确定 三个节点 ：1.树的根节点、2.左子树根节点、3.右子树根节点。
     *
     * 根据「分治算法」思想，对于树的左、右子树，仍可复用以上方法划分子树的左右子树。
     *
     * 为了提升效率，本文使用哈希表 dic 存储中序遍历的值与索引的映射，查找操作的时间复杂度为 O(1)
     * i - left + root + 1含义为 根节点索引 + 左子树长度 + 1
     * 回溯返回 node ，作为上一层递归中根节点的左 / 右子节点；；
     */

    int[] preorder;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        if(preorder == null ) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return process(0,0,preorder.length-1);
    }

    public TreeNode process(int root,int left,int right){
        if(left > right) return null;// 递归终止
        TreeNode node = new TreeNode(preorder[root]);// 建立根节点
        int i = map.get(preorder[root]);// 划分根节点、左子树、右子树
        node.left = process(root+1,left,i-1);// 开启左子树递归
        node.right = process(root+i-left + 1,i+1,right);  // 开启右子树递归
        return node;      // 回溯返回根节点
    }

}
