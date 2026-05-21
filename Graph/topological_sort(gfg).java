// Input: V = 4, E = 3, edges[][] = [[3, 0], [1, 0], [2, 0]]
// Output: 3 2 1 0

// Given a Directed Acyclic Graph (DAG) of V (0 to V-1) vertices and E edges represented as a 2D list
// of edges[][], where each entry edges[i] = [u, v] denotes a directed edge u -> v.
// Return the topological sort for the given graph.

import java.util.*;
class Solution {
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        int[] priority = new int[V];
        ArrayList<ArrayList<Integer>> mat = createGraph(V,edges, priority);
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<priority.length;i++){
            if( priority[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int j: mat.get(node)){
                priority[j]--;
                if(priority[j]==0){
                    q.add(j);
                }
            }
        }
        return ans;
    }
    
    public ArrayList<ArrayList<Integer>> createGraph(int v, int[][] edges,int[] priority){
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i=0;i<v;i++){
            mat.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int w = edges[i][1];
            mat.get(u).add(w);
            priority[w]++;
        }
        return mat;
    }
}