package SwordForOfferTwo.day15;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//剑指 Offer II 044. 二叉树每层的最大值
public class LargestValues {

public static class TreeNode {
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

    //广度优先搜索
    public List<Integer> largestValues(TreeNode root) {
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
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < num; i++) {
                if(queue.peekFirst().val > max) max = queue.peekFirst().val;
                if(queue.peekFirst().left != null) queue.offerLast(queue.peekFirst().left);
                if(queue.peekFirst().right != null) queue.offerLast(queue.peekFirst().right);
                queue.pollFirst();
            }
            list.add(max);
        }
        return list;
    }

    //DFS,利用深度deep来修改当前层的最大值
    private List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues2(TreeNode root) {
        dfs(root,0);
        return res;
    }

    // deep为深度
    public void dfs(TreeNode root, int deep){
        if (root == null) return;
        if (res.size() <= deep) res.add(root.val);
        else if (res.get(deep) < root.val) res.set(deep,root.val);
        dfs(root.left,deep + 1);
        dfs(root.right,deep + 1);
    }

}
