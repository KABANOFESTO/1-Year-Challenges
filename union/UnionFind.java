package union;

public class UnionFind {

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(0, 1);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(7, 8);
        uf.union(8, 9);

        System.out.println(uf.connected(0, 2)); // true
        System.out.println(uf.connected(3, 5)); // true
        System.out.println(uf.connected(6, 9)); // true
        System.out.println(uf.connected(0, 3)); // false
    }

    private int size;
    private int[] sz;
    private int[] id;
    private int numComponents;

    public UnionFind(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Size must be greater than 0");
        this.size = size;
        this.numComponents = size;
        sz = new int[size];
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        if (sz[rootP] < sz[rootQ]) {
            sz[rootQ] += sz[rootP];
            id[rootP] = rootQ;
        } else {
            sz[rootP] += sz[rootQ];
            id[rootQ] = rootP;
        }
        numComponents--;
    }
}
