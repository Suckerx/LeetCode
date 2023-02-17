package SwordForOffer.day14;

//剑指 Offer 12. 矩阵中的路径
public class Exist {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(process(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    //DFS + 剪枝
    public boolean process(char[][] board,String word,int i ,int j,int z){
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j]!= word.charAt(z)) return false;
        if(z == word.length()-1) return true;

        board[i][j] = '\0';//表示这个位置放问过了
        boolean result = process(board,word,i+1,j,z+1) || process(board,word,i,j+1,z+1)
                        || process(board,word,i,j-1,z+1) || process(board,word,i-1,j,z+1);
        board[i][j] = word.charAt(z);
        return result;
    }

}
