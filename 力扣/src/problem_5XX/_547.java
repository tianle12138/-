package problem_5XX;

import java.util.LinkedList;
import java.util.Queue;

public class _547 {

    //并查集
    public int findCircleNum(int[][] isConnected) {
        int citys = isConnected.length;
        UnionFind uf = new UnionFind(citys);
        for (int i = 0; i < citys; i++) {
            for (int j = i + 1; j < citys;j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.size;
    }


    // public int findCircleNum(int[][] isConnected) {
    //     int citys = isConnected.length;
    //     boolean[] visited = new boolean[citys];
    //     int provive = 0;
    //     for (int i = 0; i < citys; i++) {
    //         if(!visited[i]){
    //             // dfs(i,visited,isConnected);
    //             bfs(i,visited,isConnected);
    //             provive ++;
    //         }
    //     }
    //     return provive;
    // }



    public int findCircleNum_bfs(int[][] isConnected) {
        int citys = isConnected.length;
        boolean[] visited = new boolean[citys];
        int provive = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < citys; i++) {
            if(!visited[i]){
               q.offer(i);
               while (!q.isEmpty()){
                   int poll = q.poll();
                   visited[poll] = true;
                   for (int j = 0; j < citys; j++) {
                       if(isConnected[poll][j] == 1 && !visited[j]){
                           q.offer(j);
                       }
                   }
               }
                provive ++;
            }
        }
        return provive;
    }


    private void bfs(int index, boolean[] visited, int[][] isConnected) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while(!q.isEmpty()){
            Integer poll = q.poll();
            if(visited[poll]){
                continue;
            }else {
                visited[poll] = true;
                for (int i = 0; i < isConnected.length; i++) {
                    if(isConnected[poll][i] == 1 && !visited[i]){
                       q.offer(i);
                    }
                }
            }
        }
    }

    private void dfs(int index, boolean[] visited, int[][] isConnected) {
        for (int i = 0; i < isConnected.length; i++) {
            if(isConnected[index][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i,visited,isConnected);
            }
        }
    }
}

class UnionFind {
    int[] roots;
    int size; // 集合数量

    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        size = n;
    }

    public int find(int i) {
        if (i == roots[i]) {
            return i;
        }
        return roots[i] = find(roots[i]);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            roots[pRoot] = qRoot;
            size--;
        }
    }
}

