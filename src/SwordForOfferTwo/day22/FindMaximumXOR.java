package SwordForOfferTwo.day22;

import java.util.HashSet;

//剑指 Offer II 067. 最大的异或
public class FindMaximumXOR {

    /**
     * 哈希表解法
     * https://leetcode.cn/problems/ms70jA/solutions/1090301/zui-da-de-yi-huo-by-leetcode-solution-hr7m/
     * 因为二进制中，将一个数左移一位相当于将其乘以2，将一个数左移 n 位相当于将其乘以 $2^n$。所以在这段代码中，
     * 将 x 乘以 2 相当于将其二进制表示的所有位左移一位，而再加上 1 则相当于将其二进制表示的第 k 位变为 1。
     * 因此，xNext 的二进制表示就是在 x 的基础上将其二进制表示的第 k 位变为 1，其余位不变。
     */
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for (int i = 30; i >= 0; i--) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num >> i);
            }

            int xNext = x * 2 + 1;
            boolean found = false;

            for (int num : nums) {
                if(set.contains(xNext ^ (num >> i))){
                    found = true;
                    break;
                }
            }

            if(found) x = xNext;
            else x = xNext - 1;

        }
        return x;
    }

    /**
     * 字典树解法
     */
    // 字典树的根节点
    Trie root = new Trie();
    // 最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    public int findMaximumXOR2(int[] nums) {
        int n = nums.length;
        int x = 0;
        for (int i = 1; i < n; ++i) {
            // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            add(nums[i - 1]);
            // 将 nums[i] 看作 ai，找出最大的 x 更新答案
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    public void add(int num) {
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new Trie();
                }
                cur = cur.left;
            }
            else {
                if (cur.right == null) {
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }

    public int check(int num) {
        Trie cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
                if (cur.right != null) {
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }
            } else {
                // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                } else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }

    class Trie {
        // 左子树指向表示 0 的子节点
        Trie left = null;
        // 右子树指向表示 1 的子节点
        Trie right = null;
    }

}
