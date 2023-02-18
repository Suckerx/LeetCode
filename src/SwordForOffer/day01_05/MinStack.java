package SwordForOffer.day01_05;

import java.util.Stack;

//剑指 Offer 30. 包含min函数的栈
public class MinStack {

    private Stack<Integer> stack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    //注意点：我们动态更新的 min 值，在pop后不一定准确
    //所以，我们在push时判断，如果x<=min，那么我们就先push一个min，再push x
    //然后在pop的时候如果查看栈顶是min值，就需要pop两次得到次一级的min值
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            stack.push(x);
            min = x;
        }else{
            stack.push(x);
        }

    }

    public void pop() {
        if(stack.peek()==min){
            stack.pop();
            min = stack.pop();
        }else{
            stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }

}
