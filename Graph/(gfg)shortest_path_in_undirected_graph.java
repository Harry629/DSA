// You are given an undirected graph with V vertices numbered from 0 to V-1 and E edges,
// represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an 
// undirected edge between vertices u and v.

// Your task is to find the shortest path distance from a given source vertex src to all other
// vertices in the graph.
// If a vertex is not reachable from the source, return -1 for that vertex.


// Note: All edges have unit weight (1).

// ------------------answer------------------

import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int[][] edges = {
                            {0, 1},
                            {0, 3},
                            {1, 2},
                            {3, 4},
                            {4, 5},
                            {2, 6},
                            {5, 6},
                            {6, 7},
                            {6, 8},
                            {7, 8}
                        };
	    int src = 0;
	    int V =9;
	    int[] a = shortestPath(V,edges, src);
	    for(int i: a){
	        System.out.println(i);
	    }
	}
    public static int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> mat = createGraph(V,edges);
        
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] ans = new int[V];
        Arrays.fill(ans,-1);
        q.add(new Pair(src,0));
        visited[src] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int dist = p.dist;
            ans[node] = dist;
            for(int i:mat.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    int newDist = dist+1;
                    q.add(new Pair(i, newDist));
                }
            }
        }
        return ans;
        
    }
    public static ArrayList<ArrayList<Integer>> createGraph(int v, int[][] edges){
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i=0;i<v;i++){
            mat.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            mat.get(a).add(b);
            // mat.get(b).add(a);
        }
        return mat;
    }
    
    
    static class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
}