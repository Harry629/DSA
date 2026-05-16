import java.util.ArrayList;

public class DepthFirstSearch {
    public static ArrayList<ArrayList<Integer>> createGraph(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i=0;i<V;i++){
            mat.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            mat.get(u).add(v);
            mat.get(v).add(u);
        }
        return mat;
    }

    public static void main(String[] args) {
        int V = 5;

        // List of edges (u, v)
        int[][] edges = {
            {0, 2},
            {0, 3},
            {0, 1},
            {2, 4}
        };

        // Build the graph using edges
        ArrayList<ArrayList<Integer>> mat =createGraph(V, edges);

        System.out.println("Adjacency List Representation:");
        for (int i = 0; i < mat.size(); i++) {
            System.out.print(i+": ");
            for (int j : mat.get(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[mat.size()];
        dfs(mat, 0, ans, visited);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        
    }
    static void dfs(ArrayList<ArrayList<Integer>> mat, int node, ArrayList<Integer> ans, boolean[] visited){
        ans.add(node);
        visited[node] = true;
        for(int i: mat.get(node)){
            if(!visited[i])
                dfs(mat,i, ans, visited);
        }
    }
}