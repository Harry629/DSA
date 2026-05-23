// There is a country of n cities numbered from 0 to n - 1 where all the cities are connected 
// by bi-directional roads. The roads are represented as a 2D integer array edges where edges[i] =
// [xi, yi, timei] denotes a road between cities xi and yi that takes timei minutes to travel. 
// There may be multiple roads of differing travel times connecting the same two cities, but no road
// connects a city to itself.

// Each time you pass through a city, you must pay a passing fee. This is represented as a 0-indexed 
// integer array passingFees of length n where passingFees[j] is the amount of dollars you must pay when
// you pass through city j.

// In the beginning, you are at city 0 and want to reach city n - 1 in maxTime minutes or less. The cost
// of your journey is the summation of passing fees for each city that you passed through at some moment 
// of your journey (including the source and destination cities).

// Given maxTime, edges, and passingFees, return the minimum cost to complete your journey, or -1 if you 
// cannot complete it within maxTime minutes.

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int v = passingFees.length;
        ArrayList<ArrayList<Pair>> mat = createGraph(v, edges);
        int[][] cost = new int[v][maxTime + 1];
        for(int i = 0; i < v; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a,b)-> a.totalCost - b.totalCost);
        pq.add(new State(0, 0, passingFees[0]));
        cost[0][0]= passingFees[0];
        while(!pq.isEmpty()){
            State p = pq.poll();
            int node =p.node;
            int time = p.time;
            int totalCost = p.totalCost;
            if(node == v-1) return totalCost;
            if(totalCost > cost[node][time]) continue;
            for(Pair i: mat.get(node)){
                int newNode = i.node;
                int newTime = time + i.weight;
                if(newTime >maxTime){
                    continue;
                }
                int newCost = totalCost + passingFees[newNode];
                if(newCost < cost[newNode][newTime]){
                    cost[newNode][newTime] = newCost;
                    pq.add(new State(newNode, newTime, newCost));
                }
            }
        }
        return -1;
    }
    public ArrayList<ArrayList<Pair>> createGraph(int v, int[][] edges){
        ArrayList<ArrayList<Pair>> mat = new ArrayList<>();
        for(int i=0;i<v;i++){
            mat.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int weight = edges[i][2];
            mat.get(a).add(new Pair(b,weight));
            mat.get(b).add(new Pair(a,weight));
        }
        return mat;
    }
    class State{
        int node;
        int time;
        int totalCost;
        State(int node, int time, int totalCost){
            this.node = node;
            this.time = time;
            this.totalCost = totalCost;
        }
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