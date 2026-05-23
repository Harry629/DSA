// Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, 
// represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the 
// nodes u and v having w edge weight.
// You have to find the shortest distance of all the vertices from the source vertex src, and 
// return an array of integers where the ith element denotes the shortest distance between ith node
// and source vertex src.

import java.util.*;

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> mat = createGraph(V,edges);
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.weight-b.weight);
        
        ans[src]= 0;
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int dist = p.weight;
            if(dist > ans[node]) continue;
            for(Pair i:mat.get(node)){
                int neigh = i.node;
                if(dist+i.weight< ans[neigh]){
                    ans[neigh] = dist + i.weight;
                    pq.add(new Pair(neigh, ans[neigh]));
                }
            }
        }
        return ans;
        
    }
    
    
    public ArrayList<ArrayList<Pair>> createGraph(int v,int[][] edges){
        ArrayList<ArrayList<Pair>> mat = new ArrayList<>();
        for(int i=0;i<v;i++){
            mat.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int weight = edges[i][2];
            mat.get(a).add(new Pair(b, weight));
            mat.get(b).add(new Pair(a, weight));
        }
        return mat;
    }
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    } 
}
