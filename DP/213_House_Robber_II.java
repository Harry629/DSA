// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor
// of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

----------------- Using Recursion and memoization -----------------------------------
    
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp1 = new int[nums.length+1];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[nums.length+1];
        Arrays.fill(dp2,-1);
        int first= rec(nums,0,nums.length-1,dp1);
        int sec = rec(nums,1,nums.length,dp2);
        return Math.max(first, sec);
    }
    int rec(int[] nums,int i, int j,int[] dp){
        if(i>=j) return 0;
        if(dp[i]!=-1) return dp[i];
        int steal = nums[i]+ rec(nums,i+2,j,dp);
        int skip = rec(nums,i+1,j,dp);
        return dp[i]=Math.max(steal,skip);
    }
}

----------------- Using bottom-up approach ----------------------
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] t = new int[n+1];
        t[0]= 0;
        for(int i=1;i<=n-1;i++){
            int steal = nums[i-1]+ ((i-2 >= 0) ? t[i-2] : 0);
            int skip = t[i-1];
            t[i]= Math.max(steal,skip);
        }
        int res1 = t[n-1];
        Arrays.fill(t,0);
        t[1]=0;
        for(int i=2;i<=n;i++){
            int steal = nums[i-1]+ ((i-2 >= 0) ? t[i-2] : 0);
            int skip = t[i-1];
            t[i]= Math.max(steal,skip);
        }
        int res2 = t[n];
        return Math.max(res1,res2);
    }
}
-------------- Using constant space -----------------------

class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        int take_first = solve(nums,0, nums.length-2);
        int take_sec = solve(nums,1, nums.length-1);
        return Math.max(take_first, take_sec);
    }
    int solve(int[] nums,int m , int n){
        int prev1 = 0;
        int prev2 = 0;
        for(int i =m;i<=n;i++){
            int steal = nums[i] + prev2;
            int skip = prev1;
            int curr = Math.max(steal, skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
