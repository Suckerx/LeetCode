package SwordForOffer.day25;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

//剑指 Offer 31. 栈的压入、弹出序列
public class ValidateStackSequences {

    /**
     考虑借用一个辅助栈 stack ，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果。

     入栈操作： 按照压栈序列的顺序执行。
     出栈操作： 每次入栈后，循环判断 “栈顶元素 === 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。
     由于题目规定 栈的所有数字均不相等 ，因此在循环入栈中，每个元素出栈的位置的可能性是唯一的（若有重复数字，则具有多个可出栈的位置）。
     因而，在遇到 “栈顶元素 === 弹出序列的当前元素” 就应立即执行出栈。
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);// num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]){// 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a = new int[]{0,2,1};
        int[] b = new int[]{0,1,2};
        ValidateStackSequences v = new ValidateStackSequences();
        v.validateStackSequences(a,b);
    }

}
