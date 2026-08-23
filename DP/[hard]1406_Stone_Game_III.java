// Alice and Bob continue their games with piles of stones. There are several stones arranged in a row, and each stone has an associated value which is an integer
// given in the array stoneValue.
// Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take 1, 2, or 3 stones from the first remaining stones in the row.
// The score of each player is the sum of the values of the stones taken. The score of each player is 0 initially.
// The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues
// until all the stones have been taken.
// Assume Alice and Bob play optimally.
// Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie" if they will end the game with the same score.

---------------------------- dp ---------------------------------------------------
  class Solution {
    int n;
    int[][] dp;
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        dp = new int[2][n+1];
        for(int i=0;i<2;i++){
            Arrays.fill(dp[i],-1);
        }
        int result1 = aliceTurn(stoneValue, 1,0);
        int totalSum =0;
        for(int i: stoneValue){
            totalSum += i;
        }
        int result2 = totalSum - result1;
        if(result2 == result1) return "Tie";
        return (result1 > result2) ? "Alice": "Bob";
    }
    public int aliceTurn(int[] arr, int person, int i){
        if(i>=n) return 0;
        if(dp[person][i]!=-1) return dp[person][i];
        int stones =0;
        int result = (person==1)? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for(int j=1;j<=Math.min(3, n-i);j++){
            stones += arr[i+j-1];
            if(person ==1){
                result = Math.max(result, stones + aliceTurn(arr,0,i+j));
            }else{
                result = Math.min(result, aliceTurn(arr,1, i+j));
            }
        }
        return dp[person][i]=result;
    }
}
