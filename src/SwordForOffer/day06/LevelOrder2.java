package SwordForOffer.day06;

import java.util.*;

//剑指 Offer 32 - III. 从上到下打印二叉树 III
public class LevelOrder2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     为了满足题目要求的返回值为「先从左往右，再从右往左」交替输出的锯齿形，我们可以利用「双端队列」的数据结构来维护当前层节点值输出的顺序。

     双端队列是一个可以在队列任意一端插入元素的队列。在广度优先搜索遍历当前层节点拓展下一层节点的时候我们仍然从左往右按顺序拓展，
     但是对当前层节点的存储我们维护一个变量 isOrderLeft 记录是从左至右还是从右至左的：

     如果从左至右，我们每次将被遍历到的元素插入至双端队列的末尾。

     如果从右至左，我们每次将被遍历到的元素插入至双端队列的头部。
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null) return list;

        queue.offer(root);
        boolean isLeft = true;

        while(!queue.isEmpty()){
            Deque<Integer> inList = new LinkedList<>();
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if(isLeft){
                    inList.offerLast(node.val);
                }else{
                    inList.offerFirst(node.val);
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            isLeft = !isLeft;
            list.add(new LinkedList<Integer>(inList));
        }
        return list;
    }

}
