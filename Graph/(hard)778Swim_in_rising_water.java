// You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that
// point (i, j).

// It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any 
// cell with elevation less than equal to t is submerged or reachable.

// You can swim from a square to another 4-directionally adjacent square if and only if the elevation
// of both squares individually are at most t. You can swim infinite distances in zero time. Of course,
// you must stay within the boundaries of the grid during your swim.

// Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at
// the top left square (0, 0).

class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,1,-1};
    public int swimInWater(int[][] heights) {
        int srcRow = 0, srcCol = 0, destRow = heights.length-1, destCol = heights[0].length-1;
        int[][] mat = new int[heights.length][heights[0].length];
        for(int i=0;i<mat.length;i++){
            Arrays.fill(mat[i],Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.weight- b.weight);
        pq.add(new Pair(0,0,heights[0][0]));
        mat[0][0]= heights[0][0];
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int row = p.row;
            int col = p.col;
            int weight = p.weight;
            if(weight > mat[row][col]) continue;
            for(int i=0;i<4;i++){
                int newRow = row + x[i];
                int newCol = col + y[i];
                if(isValid(newRow, newCol, heights.length,heights[0].length)){
                    System.out.println("inside");
                    int newWeight = Math.max(weight,heights[newRow][newCol]);
                    if(newWeight < mat[newRow][newCol]){
                        pq.add(new Pair(newRow,newCol, newWeight));
                        mat[newRow][newCol]= newWeight;
                        System.out.println(mat[newRow][newCol]+" ");
                    }
                }
            }
            System.out.println();
        }
        return mat[destRow][destCol];
    }
    public boolean isValid(int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n){
            return false;
        }
        return true;
    }

    class Pair{
        int row;
        int col;
        int weight;
        Pair(int row, int col, int weight){
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }
}