package SwordForOfferTwo.day15;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//剑指 Offer II 045. 二叉树最底层最左边的值
public class FindBottomLeftValue {

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

    //BFS,转换为找每一层最左的节点，然后返回最后一层的
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);

        while(!queue.isEmpty()){
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                if(i == 0) list.add(queue.peekFirst().val);
                if(queue.peekFirst().left != null) queue.offerLast(queue.peekFirst().left);
                if(queue.peekFirst().right != null) queue.offerLast(queue.peekFirst().right);
                queue.pollFirst();
            }
        }
        return list.get(list.size() - 1);
    }

    //DFS
    /**
     * 使用 height 记录遍历到的节点的高度，
     * curVal记录高度在 curHeight的最左节点的值。在深度优先搜索时，
     * 我们先搜索当前节点的左子节点，再搜索当前节点的右子节点，然后判断当前节点的高度 height是否大于 curHeight，
     * 如果是，那么将 curVal设置为当前结点的值，curHeight设置为 height。
     * 因为我们先遍历左子树，然后再遍历右子树，所以对同一高度的所有节点，最左节点肯定是最先被遍历到的。
     */
    int curVal = 0;
    int curHeight = 0;
    public int findBottomLeftValue2(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root,int deep){
        if(root == null) return ;
        deep++;
        dfs(root.left,deep);
        dfs(root.right,deep);
        if(deep > curHeight){
            curHeight = deep;
            curVal = root.val;
        }
    }


}
