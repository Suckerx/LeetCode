package SwordForOffer.day15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer 34. 二叉树中和为某一值的路径
public class PathSum {

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
     * 本问题是典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分。
     * 先序遍历： 按照 “根、左、右” 的顺序，遍历树的所有节点。
     * 路径记录： 在先序遍历中，记录从根节点到当前节点的路径。
     * 当路径为 ① 根节点到叶节点形成的路径 且 ② 各节点值的和等于目标值 sum 时，将此路径加入结果列表。
     *
     * 值得注意的是，记录路径时若直接执行 res.append(path) ，则是将 path 对象加入了 res ；
     * 后续 path 改变时， res 中的 path 对象也会随之改变。
     * 正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。
     */

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root,target);
        return res;
    }

    public void recur(TreeNode root,int target){
        if(root == null) return ;
        path.add(root.val);
        target-=root.val;
        if(root.left == null && root.right == null && target == 0) res.add(new LinkedList<>(path));
        recur(root.left,target);
        recur(root.right,target);
        path.removeLast();
    }

}
