// Given an array of integers arr[] and an integer target. We need to build an expression out of arr[] by adding one of the symbols '+' or  '-' 
// before each integer in arr[] and then concatenate all the integers. 
// For example : if arr[] = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
// Return the number of different expressions that can be built, which evaluates to target.

// Note : An expression is considered different from another if the placement of '+' and '-' operators differs, even if the resulting value is the same. 

------------------------------------------Solution---------------------------------------------------------------------------------------------------------

  class Solution {
    public int totalWays(int[] arr, int target) {
        // code here
        int n= arr.length;
        int sum = sumOfArray(arr);
        int totalLength= sum*2 +1;
        int[][] dp = new int[n+1][totalLength];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return total(arr, target, 0,dp, sum);
    }
    public int total(int[] arr, int target, int i, int[][] dp, int sum){
        if (target > sum || target < -sum) {
            return 0;
        }
        if(dp[i][target+sum]!= -1) return dp[i][target+sum];
        if(i== arr.length){
            if(target==0){
                return dp[i][target + sum]= 1;
            }
            else{
                return dp[i][target + sum]=0;
            }
        }
        int take = total(arr, target-arr[i], i+1,dp, sum);
        int skip = total(arr, target+arr[i], i+1,dp, sum);
        return dp[i][target + sum]=take+skip;
    }
    public int sumOfArray(int[] num){
        int sum =0;
        for(int i: num){
            sum += i;
        }
        return sum;
    }
}
