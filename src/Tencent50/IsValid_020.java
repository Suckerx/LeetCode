package Tencent50;

import java.util.Stack;

//20. 有效的括号
public class IsValid_020 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{') stack.push(chars[i]);
            else if(chars[i] == ')'){
                if(!stack.isEmpty() && stack.pop() == '(') continue;
                else return false;
            }
            else if(chars[i] == '}'){
                if(!stack.isEmpty() && stack.pop() == '{') continue;
                else return false;
            }
            else if(chars[i] == ']'){
                if(!stack.isEmpty() && stack.pop() == '[') continue;
                else return false;
            }
        }
        return stack.isEmpty();
    }

}
