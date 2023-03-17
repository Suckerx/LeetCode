package SwordForOfferTwo.day15;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer II 046. 二叉树的右侧视图
public class RightSideView {

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

    //BFS:将条件转换为求每一层的最右边的节点
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;
        queue.offerLast(root);
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }

        while(!queue.isEmpty()){
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                if(i == 0) list.add(queue.peekFirst().val);
                if(queue.peekFirst().right != null) queue.offerLast(queue.peekFirst().right);
                if(queue.peekFirst().left != null) queue.offerLast(queue.peekFirst().left);
                queue.pollFirst();
            }
        }
        return list;
    }

    //dfs
    private List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root,int deep){
        if (root == null) return;
        if (res.size() <= deep) res.add(root.val);
        dfs(root.right,deep + 1);
        dfs(root.left,deep + 1);
    }

}
