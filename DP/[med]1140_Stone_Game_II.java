// Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each pile has a positive integer number of
// stones piles[i]. The objective of the game is to end with the most stones.

// Alice and Bob take turns, with Alice starting first.

// On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M. Then, we set M = max(M, X). Initially, M = 1.

// The game continues until all the stones have been taken.

// Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

-------------------- dp ---------------------------------------
  class Solution {
    int n;
    int[][][] dp = new int[2][101][101];
    public int stoneGameII(int[] piles) {
        n = piles.length;
        for(int i=0;i<2;i++){
            for(int j=0;j<101;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solveForAlice(piles, 1, 0, 1);
    }

    public int solveForAlice(int[] piles, int person,int i, int M){
        if(i>=n){
            return 0;
        }
        if(dp[person][i][M]!=-1) return dp[person][i][M];
        int result = (person==1)? -1 : Integer.MAX_VALUE;
        int stones =0;
        for(int x=1;x <= Math.min(2*M , n-i);x++){
            stones += piles[i+x-1];
            if(person==1){
                result = Math.max(result, stones+solveForAlice(piles,0,i+x, Math.max(M,x)));
            }else{
                result = Math.min(result, solveForAlice(piles, 1, i+x, Math.max(M,x)));
            }
        }
        return dp[person][i][M]=result;
    }


}
