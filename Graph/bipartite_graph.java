// Given a Graph with V vertices (Numbered from 0 to V-1) and E edges. Check whether the graph is
// bipartite or not.

// A bipartite graph can be colored with two colors such that no two adjacent vertices share the same color.
// This means we can divide the graph’s vertices into two distinct sets where:

// All edges connect vertices from one set to vertices in the other set.
// No edges exist between vertices within the same set.

import java.util.*;
class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        boolean ans = true;
        ArrayList<ArrayList<Integer>> mat = createGraph(V, edges);
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[V];
        for(int i=0;i<V;i++){
            color[i] =-1;
        }
        q.add(0);
        color[0] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i: mat.get(node)){
                if(color[i]==-1){
                    color[i] = 1-color[node];
                    q.add(i);
                }else{
                    if(color[i]==color[node]){
                        ans = false;
                    }
                }
            }
        }
        return ans;
        
    }
    public ArrayList<ArrayList<Integer>> createGraph(int v, int[][] edges){
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i=0;i<v;i++){
            mat.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int w = edges[i][1];
            mat.get(u).add(w);
            mat.get(w).add(u);
        }
        return mat;
    }
}