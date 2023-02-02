package SwordForOffer.day06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//剑指 Offer 32 - II. 从上到下打印二叉树 II
public class LevelOrder1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // BFS,注意这里的返回值条件，每一层是一个list
    //那么就可以用变量记录每一层的节点个数
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        queue.add(root);
        int number = 1;//number用于记录当前层的节点个数
        while(!queue.isEmpty()){
            int i = number;//i变量用于控制循环，即当前层节点个数
            number = 0;//清空number以便记录下一层节点个数
            List<Integer> inList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                TreeNode node = queue.poll();
                inList.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                    number++;
                }
                if(node.right != null) {
                    queue.add(node.right);
                    number++;
                }
            }
            list.add(inList);
        }
        return list;
    }

}
