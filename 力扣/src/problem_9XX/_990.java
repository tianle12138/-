package problem_9XX;

import java.util.Arrays;

public class _990 {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] size = new int[26];
        Arrays.fill(size, 1);
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, size, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (isConnect(parent, index1, index2)) {
                    return false;
                }
            }
        }
        return true;

    }

    private void union(int[] parent, int[] size, int p, int q) {
        int rootP = find(parent, p);
        int rootQ = find(parent, q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] >= size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }

    private int find(int[] parent, int q) {
        while (parent[q] != q) {
            q = parent[q];
        }
        return q;
    }

    private boolean isConnect(int[] parent, int p, int q) {
        return find(parent, p) == find(parent, q);
    }

}
