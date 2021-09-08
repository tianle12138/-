package problem_6XX;

public class _684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind clz = new UnionFind(n);
        int[] ans = new int[2];
        for (int[] edge : edges) {
            int node1 = edge[0]-1;
            int node2 = edge[1]-1;
            if (clz.find(node1) == clz.find(node2)) {
                ans[0] = node1+1;
                ans[1] = node2+1;
                break;
            }
            clz.union(node1, node2);
        }
        return ans;
    }
}
class UnionFind{
    int[] root;
    int value;
    public UnionFind(){}
    public UnionFind(int value) {
        this.root = new int[value];
        this.value = value;
        for (int i = 0; i < value; i++) {
            root[i] = i;
        }
    }
    public int find(int node){
        if(root[node] != node){
            root[node] = find(root[node]);
        }
        return root[node];
    }
    public void union(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP != rootQ){
            root[rootP] = rootQ;
        }
    }

}