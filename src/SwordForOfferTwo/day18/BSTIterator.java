package SwordForOfferTwo.day18;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer II 055. 二叉搜索树迭代器
public class BSTIterator {

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

    private List<TreeNode> list;
    private int id;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        this.id = 0;
        process(root);
    }

    public void process(TreeNode root){
        if(root == null) return ;
        process(root.left);
        list.add(root);
        process(root.right);
    }

    public int next() {
        return list.get(id++).val;
    }

    public boolean hasNext() {
        return id < list.size();
    }

    //解法二：满足无额外空间：利用二叉搜索树中序遍历是升序的特点，修改指针指向，将二叉树转换为升序链表，除了递归栈空间，无额外空间

}
