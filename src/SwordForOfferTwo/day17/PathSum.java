package SwordForOfferTwo.day17;

import java.util.*;

//剑指 Offer II 050. 向下的路径节点之和
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


    //https://leetcode.cn/problems/6eUYwP/solutions/1038418/xiang-xia-de-lu-jing-jie-dian-zhi-he-by-a1iyy/
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int ret = dfs(root,targetSum);
        //对每个节点都进行穷举
        ret += pathSum(root.left,targetSum);
        ret += pathSum(root.right,targetSum);
        return ret;
    }

    //这里targetSum 使用long 类型，否则溢出
    public int dfs(TreeNode root ,long targetSum){
        int ret = 0;
        if(root == null) return 0;
        if(root.val == targetSum) ret++;
        ret += dfs(root.left,targetSum - root.val);
        ret += dfs(root.right,targetSum - root.val);
        return ret;
    }

    //前缀和解法，配合官方题解：https://leetcode.cn/problems/6eUYwP/solutions/1038418/xiang-xia-de-lu-jing-jie-dian-zhi-he-by-a1iyy/
    //和这个题解 https://leetcode.cn/problems/6eUYwP/solutions/1958756/qian-zhui-he-di-gui-by-bold-nashavq-1713/

    //记录当前前缀和出现次数
    private Map<Long,Integer> preSumCount = new HashMap<>();
    //目标值
    private int target;

    public int pathSum2(TreeNode root, int targetSum) {
        this.target = targetSum;
        // 记录前缀和为0的次数为1
        preSumCount.put(0L, 1);
        // 前缀和使用Long，原因单节点最大值10的9次方，使用int会溢出
        return dfs2(root, 0L);
    }

    public int dfs2(TreeNode root,Long currSum){
        //base case
        if(root == null) return 0;
        //记录结果
        int ret = 0;
        currSum += root.val;

        //当前前缀和减去目标值 如果Map中有记录，则说明从某一点到当前节点的和等于目标值target
        ret += preSumCount.getOrDefault(currSum - target,0);
        // 把当前前缀和加入Map
        preSumCount.put(currSum,preSumCount.getOrDefault(currSum,0)+1);

        ret += dfs2(root.left,currSum);
        ret += dfs2(root.right,currSum);

        // 恢复本层记录过的前缀和,恢复状态的原因是因为防止在不同分支上的节点满足target，但并不属于题目要求
        preSumCount.put(currSum, preSumCount.get(currSum) - 1);

        return ret;
    }



}
