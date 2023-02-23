package SwordForOffer.day28;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer 37. 序列化二叉树
public class Codec {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * BFS使用队列实现，注意数组转String每个元素前面有空格
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                res.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else res.add(null);
        }
        return res.toString().replaceAll(" ","");
    }

    //反序列化也是使用队列，用指针i 控制每个元素的左右子节点位置
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;//指针，指向每个节点的左节点，然后不断++
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

}
