// Alice and Bob take turns playing a game, with Alice starting first.

// Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.

// Also, if a player cannot make a move, he/she loses the game.

// Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both players play optimally.
--------------------- dp (my way) ---------------------------------------- 
  class Solution {
    Boolean[][] dp;
    public boolean winnerSquareGame(int n) {
        dp = new Boolean[2][n+1];
        return checkAlice(n, 1);
    }
    public boolean checkAlice(int n, int person){
        if(n==0){
            if(person==1) return dp[person][n]=false;
            else{
                return dp[person][n]=true;
            }
        } 
        if(dp[person][n]!= null) return dp[person][n];
        boolean alice=false;
        boolean bob= false;
        if(person==1){
            for(int k=1;Math.pow(k,2) <= n;k++){
                // if below is true, means Alice has atleast one move which will make her win
                if(checkAlice(n-k*k,0)==true){
                    return dp[person][n]=true;
                }
            }
            return dp[person][n]=false;
        }
        else{
            for(int k=1;k*k <= n;k++){
                // here, bob has one move which make him win, so Alice can't win from here
                if(checkAlice(n-k*k, 1)==false){
                    return dp[person][n]=false;
                }
            }
            return dp[person][n]=true;
        }
    }
}

------------------- easy pheasy --------------------------------------------------------------------------
  class Solution {
    Boolean[][] dp;
    public boolean winnerSquareGame(int n) {
        dp = new Boolean[2][n+1];
        return checkAlice(n, 1);
    }
    public boolean checkAlice(int n, int person){
        if(n==0){
            return dp[person][n]=false;
        } 
        if(dp[person][n]!= null) return dp[person][n];
        for(int k=1;k*k<=n;k++){
          // here we are calculating the prob of getting to false in bob's case, so that alice can win
            if(checkAlice(n-k*k, 0)==false){
                return dp[person][n]=true;
            }
        }
        return dp[person][n]=false;
    }
}
