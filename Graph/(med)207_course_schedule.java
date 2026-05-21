// it is a problem where we have to detect whether there is a cycle in the graph or not

//Question : 
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
// course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> mat =createGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i=0;i<mat.size();i++){
            if(dfs(mat, i, visited, path)){
                return false;
            }
        }
        return true;
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
        }
        return mat;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> mat, int node, boolean[] visited, boolean[] path){
        path[node] = true;
        visited[node] = true;
        for(int i: mat.get(node)){
            if(!visited[i]){
                if(dfs(mat,i, visited,path)){
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