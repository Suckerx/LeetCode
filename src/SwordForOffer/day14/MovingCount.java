package SwordForOffer.day14;

import java.util.LinkedList;
import java.util.Queue;

//面试题13. 机器人的运动范围
public class MovingCount {

    int n,m,k;
    boolean[][] visited;

    //通过推导得出可达性解只需要向下和向右递归即可
    public int movingCount(int m, int n, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
        visited = new boolean[m][n];
        return process(0,0,0,0);
    }

    //DFS + 剪枝
    public int process(int i,int j ,int si,int sj){
        if(i >= m || j >= n || visited[i][j] || si+sj > k) return 0;
        visited[i][j] = true;
        return 1+process(i,j+1,si,sums(j+1))+process(i+1,j,sums(i+1),sj);
    }

    public static int sums(int x){
        int s = 0;
        while(x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }

    //通常使用队列实现BFS
    //一般定义队列：Queue<> queue = new LinkedListed<>();
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int res = 0;

        queue.add(new int[]{0,0,0,0});
        while(queue.size() > 0){
            int[] x = queue.poll();
            int i = x[0],j = x[1],si = x[2],sj = x[3];

            if(i >= m || j >= n || visited[i][j] || si+sj > k) continue;

            visited[i][j] = true;
            res++;
            queue.add(new int[]{i+1,j,sums(i+1),sj});
            queue.add(new int[]{i,j+1,si,sums(j+1)});
        }
        return res;
    }

}
