The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus the sum of the elements at odd indices.
For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing the elements of the subsequence).
A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the
remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums,0,true,dp);
    }
    long solve(int[] nums,int idx, boolean flag,long[][] dp){
        if(idx>=nums.length) return 0;
         int f = flag ? 1 : 0;
        if(dp[idx][f]!=-1) return dp[idx][f];
        long skip = solve(nums, idx+1,flag,dp);
        long val = nums[idx];
        if(!flag){
            val = -val;
        }
        long take = solve(nums, idx+1, !flag,dp)+ val;
        return dp[idx][f]=Math.max(skip, take);
    }
}


--------------------------- BottomUp approach ------------------------------------

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[nums.length+1][2];
        for(int i =1;i<n+1;i++){
            //even
            dp[i][0]= Math.max(dp[i-1][1]-nums[i-1],dp[i-1][0]);
            //odd
            dp[i][1] = Math.max(dp[i-1][0]+nums[i-1],dp[i-1][1]); 
        }
        return Math.max(dp[n][0],dp[n][1]);
    }
}
