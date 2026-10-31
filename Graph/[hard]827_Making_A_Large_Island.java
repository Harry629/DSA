You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

  -------------------------------- sol--------------------------
  class Solution {
    int n;
    int[] x ={-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int largestIsland(int[][] grid) {
        n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                for(int k=0;k<4;k++){
                    int row = i+ x[k];
                    int col = j + y[k];
                    if(isValid(row, col,n) && grid[row][col]==1){
                        int node = i*n + j;
                        int newNode = row *n + col;
                        ds.unionSize(newNode, node);
                    }
                }
            }
        }

        int mx =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> hs = new HashSet<>();
                for(int k=0;k<4;k++){
                    int row = i+ x[k];
                    int col = j + y[k];
                    if(isValid(row, col,n)){
                        if(grid[row][col]==1){
                            int newNode = row *n + col;
                            hs.add(ds.findP(newNode));
                        }
                    }
                }
                int sizeTotal=1;
                for(Integer a : hs){
                    sizeTotal += ds.size[a];
                }
                mx = Math.max(sizeTotal, mx);
            }
        }
        for(int i=0;i<n*n;i++){
            mx = Math.max(mx, ds.size[ds.findP(i)]);
        }
        return mx;
    }

    public boolean isValid(int x, int y, int n){
        if(x<0 || y<0 || x>=n || y>=n){
            return false;
        }
        return true;
    }
    class DisjointSet{
        int[] parent;
        int[] size;
        public DisjointSet(int node){
            parent = new int[n*n];
            size = new int[n*n];
            for(int i=0;i<node;i++){
                parent[i]=i;
                size[i] = 1;
            }
        }
        public int findP(int node){
            if(node == parent[node]){
                return node;
            }
            int p =findP(parent[node]);
            parent[node] = p;
            return p;
        }
        public void unionSize(int u, int v){
            int Pu = findP(u);
            int Pv = findP(v);
            if(Pu == Pv) return;
            if(size[Pu] < size[Pv]){
                parent[Pu] = Pv;
                size[Pv] = size[Pu]+ size[Pv];
            }else{
                parent[Pv] = Pu;
                int sizea = size[Pv];
                size[Pu] = size[Pu] + sizea;
            }
        }
    }
}
