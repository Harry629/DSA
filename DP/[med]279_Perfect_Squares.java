// Given an integer n, return the least number of perfect square numbers that sum to n.

// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
// For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

class Solution {
    final int INF = 999999999;

    public int numSquares(int n) {
        List<Integer> sqrList= sqrt(n);
        int size = sqrList.size();
        int[][] dp = new int[size][n+1];
        for(int i=0;i<size;i++){
            Arrays.fill(dp[i],-1);
        }
        return checkNum(sqrList, n, size-1,dp);
    }


    public int checkNum(List<Integer> sqrList, int n, int i,int[][] dp){
        if(dp[i][n] != -1) return dp[i][n];
        
        if(n==0) return 0;
        if(sqrList.get(i)==1){
            return dp[i][n]= n;
        }
        int take = INF;
        if(n-sqrList.get(i) >= 0 ){
            take = 1+ checkNum(sqrList, n-sqrList.get(i),i,dp);
        }
        int skip = checkNum(sqrList, n, i-1,dp);
        return dp[i][n]=Math.min(skip, take);
    }


    public List<Integer> sqrt(int n){
        List<Integer> arr = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            arr.add(i*i);
        }
        return arr;
    }
}
