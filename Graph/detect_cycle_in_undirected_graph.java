import java.util.*;
import java.util.Collections;

public class detect_cycle_in_undirected_graph {
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
        int V = 7;

        // List of edges (u, v)
        int[][] edges = {
            {0,1},
            {0,2},
            {1,3},
            {4,5},
            {5,6},
            {6,4}
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
        boolean ans1= false;
        for(int i=0;i<mat.size();i++){
            if(!visited[i]){
                ans1 = dfs(mat,i,ans,visited,-1);
                if(ans1 == true){
                    System.out.print("true");
                    break;
                }
            }
        }
        if(ans1 == false)
            System.out.print("false");
        
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> mat, int node, ArrayList<Integer> ans, boolean[] visited, int parent){
        ans.add(node);
        visited[node] = true;
        for(int i: mat.get(node)){
            if(!visited[i]){
                if(dfs(mat,i, ans, visited,node)){
                  return true;  
                }
            }
            else if(parent != i){
                return true;
            }
        }
        return false;
    }
}