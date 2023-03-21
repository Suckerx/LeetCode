package SwordForOfferTwo.day16;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//剑指 Offer II 048. 序列化与反序列化二叉树
public class Codec {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      //DFS + 先序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root,"");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(strings));
        return rdeserialise(dataList);
    }

    public String rserialize(TreeNode root,String str){
        if(root == null){
            str += "None,";
        }else{
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left,str);
            str = rserialize(root.right,str);
        }
        return str;
    }

    public TreeNode rdeserialise(List<String> list){
        if(list.get(0).equals("None")){
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = rdeserialise(list);
        node.right = rdeserialise(list);
        return node;
    }


    /**
     * BFS
     */
    public String serialize2(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != null){
                res.append("" + node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                res.append("null");
            }
            res.append(",");
        }
        return res.toString();
    }

    public TreeNode deserialize2(String data) {
        if(data == ""){
            return null;
        }
        String[] dataList = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!"null".equals(dataList[i])){
                node.left = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.left);
            }
            i++;
            if(!"null".equals(dataList[i])){
                node.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }


}
