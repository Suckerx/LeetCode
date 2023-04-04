package SwordForOfferTwo.day29;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer II 085. 生成匹配的括号
public class GenerateParenthesis {

    //https://leetcode.cn/problems/IDBivT/solutions/941818/jian-dan-yi-dong-javac-pythonjs-pei-yang-mmhs/?orderBy=hot&languageTags=java
    //回溯法都可以抽象成树形结构的DFS
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        dfs(n,"",res,0,0);
        return res;
    }

    public void dfs(int n,String path,List<String> res,int open,int close){
        if(open > n || close > open) return;
        if(path.length() == n * 2){
            res.add(path);
            return;
        }
        dfs(n,path + "(",res,open + 1,close);//回溯后不需要撤销状态，因为String不可变，回溯后自动撤销
        dfs(n,path + ")",res,open,close + 1);
    }

}
