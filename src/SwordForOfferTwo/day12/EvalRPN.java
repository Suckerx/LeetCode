package SwordForOfferTwo.day12;

import java.util.Stack;

//剑指 Offer II 036. 后缀表达式
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                if(stack.size() >= 2){
                    int x = Integer.valueOf(stack.pop());
                    int y = Integer.valueOf(stack.pop());
                    if(token.equals("+")) stack.push(String.valueOf(x+y));
                    else if(token.equals("-")) stack.push(String.valueOf(y - x));
                    else if(token.equals("*")) stack.push(String.valueOf(y * x));
                    else if(token.equals("/")) stack.push(String.valueOf(y / x));
                }
            }
            else stack.push(token);
        }
        return Integer.valueOf(stack.pop());
    }

}
