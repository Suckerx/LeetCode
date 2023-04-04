package SwordForOfferTwo.day29;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer II 087. 复原 IP
public class RestoreIpAddresses {

    private List<String> ans = new ArrayList<>();
    int[] segements = new int[4];

    //https://leetcode.cn/problems/0on3uN/solutions/1404274/fu-yuan-ip-by-leetcode-solution-2lfx/
    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,0);
        return ans;
    }

    public void dfs(String s,int segId,int segStart){
        if(segId == 4){
            if(segStart == s.length()){
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < 4; i++) {
                    stringBuffer.append(segements[i]);
                    if(i != 3) stringBuffer.append(".");
                }
                ans.add(stringBuffer.toString());
            }
            return;
        }

        if(segStart == s.length()) return;

        if(s.charAt(segStart) == '0'){
            segements[segId] = 0;
            dfs(s,segId + 1,segStart + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if(addr > 0 && addr <= 255) {
                segements[segId] = addr;
                dfs(s,segId + 1,segEnd + 1);
            }
            else break;
        }

    }

}
