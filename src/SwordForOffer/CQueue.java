package SwordForOffer;

import java.util.Deque;
import java.util.Stack;

//剑指 Offer 09. 用两个栈实现队列
public class CQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    //只在inStack中添加元素
    public void appendTail(int value) {
        inStack.push(value);
    }

    //删除元素前，先把inStack中的元素放到outStack中，然后删除后再放回去
    public int deleteHead() {
        int result = -1;

        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        if(outStack.isEmpty()) return -1;

        result = outStack.pop();

        while(!outStack.isEmpty()){
            inStack.push(outStack.pop());
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(1);
    }


}
