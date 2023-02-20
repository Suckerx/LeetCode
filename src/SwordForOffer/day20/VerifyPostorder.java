package SwordForOffer.day20;


import java.util.Arrays;
import java.util.HashMap;

//剑指 Offer 33. 二叉搜索树的后序遍历序列
public class VerifyPostorder {

    //方法一：递归分治
    //根据二叉搜索树的定义，可以通过递归，判断所有子树的 正确性 （即其后序遍历是否满足二叉搜索树的定义） ，
    // 若所有子树都正确，则此序列为二叉搜索树的后序遍历。
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }

    /**
     * 划分左右子树： 遍历后序遍历的 [i,j]区间元素，寻找 第一个大于根节点 的节点，
     * 索引记为 m 。此时，可划分出左子树区间 [i,m−1]、右子树区间 [m,j−1]、根节点索引 j
     * 判断是否为二叉搜索树：
     * 左子树区间 [i,m−1]内的所有节点都应 < postorder[j] 。
     * 而第 1.划分左右子树 步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可。
     * 右子树区间 [m,j−1]内的所有节点都应 > postorder[j]。实现方式为遍历，当遇到 ≤postorder[j]
     * 的节点则跳出；则可通过 p=j判断是否为二叉搜索树。
     */

    public boolean recur(int[] postorder,int i,int j){
        if(i>=j) return true; //终止条件,明此子树节点数量 <=1
        int p = i;
        while(postorder[p]<postorder[j]) p++;
        int m = p;
        while(postorder[p]> postorder[j]) p++;
        return p == j && recur(postorder,i,m-1) && recur(postorder,m,j-1);
    }


    /**
     * 因为为二叉搜索树，且任意两个数字都互不相同，则我们对后序遍历数组进行升序排序即可得到中序遍历数组。
     * 在得到中序遍历数组后，可根据节点所在中序遍历的位置确定其左右子树节点的个数，即可实现对后序遍历数组中某个 节点得到其对应的左右子树节点。
     * 划分左右子树后，即可分别比较左右子树各点的数值与其根节点的数值大小来判断书否满足二叉搜索树的特点：
     * 左子树所有节点数值均小于根节点的数值； 右子树所有节点数值均大于根节点的数值；
     */
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public boolean verifyPostorder2(int[] postorder) {
        this.postorder = postorder;
        inorder = postorder.clone();
        Arrays.sort(inorder);       //获取中序遍历数组
        for (int i=0; i< inorder.length; i++){ //将中序遍历数组及其对应下表存储至哈希表中便于查询
            map.put(inorder[i], i);
        }

        return recur(postorder.length - 1,0, postorder.length - 1);
    }

    boolean recur(int root,int left, int right) {
        if (left >= right) return true;

        int i = map.get(postorder[root]); // 获取当前节点在中序遍历数组中的下标i
        int numOfLeft = i - left;    // 计算当前节点左子树节点的个数
        int numOfRight = right-i;    // 计算当前节点右子树节点的个数

        for (int j = root-1; j >= root-numOfRight; j--) {       // 判断当前节点的右子树所有节点是否满足其数值均大于当前节点的数值
            if (postorder[j] < postorder[root]) return false;   // 若不满足则返回false
        }

        for (int j = root-numOfRight-1; j>= root-numOfRight-numOfLeft;j--){ // 判断当前节点的左子树所有节点是否满足其数值均小于当前节点的数值
            if (postorder[j] > postorder[root]) return false;               // 若不满足则返回false
        }


        return recur(root-(right-i)-1,left, i-1) && recur(root-1, i+1, right); // 递归查询左右子树
    }


}
