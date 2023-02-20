package SwordForOffer.day19;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;

//剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 通过递归把所有节点的父节点都保存到Map集合里面
     * 然后再将第一个节点的父节点都录到一个Set集合里面，就是当前节点不跟它的父节点相同则保存进去，
     * 直到头节点循环停止，然后你再把头节点放进去，然后用循环遍历第二个节点o2，当遇到第一个父亲节点在Set集合里面就表示找到了最低公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        fatherMap.put(root,root);
        process(root,fatherMap);
        HashSet<TreeNode> set = new HashSet<>();
        TreeNode cur = p;
        while(cur!=fatherMap.get(cur)){
            set.add(cur);
            cur = fatherMap.get(cur);
        }
        set.add(cur);
        cur = q;
        if(set.contains(q)) return q;
        while(!set.contains(fatherMap.get(cur))){
            cur = fatherMap.get(cur);
        }
        return fatherMap.get(cur);
    }

    public static void process(TreeNode root, HashMap<TreeNode, TreeNode> map){
        if(root == null) return ;
        map.put(root.left,root);
        map.put(root.right,root);
        process(root.left,map);
        process(root.right,map);
    }

    //方法二：
    /**
     * 可以分为几个情况：
     *
     * - o1是o2的LCA，或者o2是o1的LCA
     * - o1和o2彼此不是最低公共祖先
     *
     * 这个代码意思是：如果某个子树上没有o1或者o2，那么这个子树一定返回空，遇到o1或o2直接往上返回
     *
     * 而如果两个节点不互为LCA，那么有o1的子树会返回o1，有o2的子树会返回o2，此时会中那个if判断条件，返回他们的头节点
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        if(left!=null && right!=null) return root;
        return left!=null ? left : right;
    }

}
