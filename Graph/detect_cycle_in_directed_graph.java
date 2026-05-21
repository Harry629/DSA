import java.util.*;
import java.util.Collections;

public class detect_cycle_in_directed_graph {
    public static ArrayList<ArrayList<Integer>> createGraph(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i=0;i<V;i++){
            mat.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            mat.get(u).add(v);
            // mat.get(v).add(u);
        }
        return mat;
    }

    public static void main(String[] args) {
        int V = 4;

        // List of edges (u, v)
        int[][] edges = {
            {0,1},
            {0,2},
            {1,3},
            {3,2},
            {2,0}
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
        // ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[mat.size()];
        boolean[] path = new boolean[mat.size()];
        boolean ans1= false;
        for(int i=0;i<mat.size();i++){
            ans1 = dfs(mat, i, path, visited);
            if(ans1){
                System.out.print("true");
                break;
            }
        }
        if(ans1 == false)
            System.out.print("false");
        
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> mat, int node, boolean[] path, boolean[] visited){
        // ans.add(node);
        path[node] = true;
        visited[node] = true;
        for(int i: mat.get(node)){
            if(!visited[i]){
                if(dfs(mat,i, path, visited)){
                  return true;  
                }
            }
            else if(path[i]){
                return true;
            }
        }
        path[node] = false;
        return false;
    }
}