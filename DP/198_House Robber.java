You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping 
you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent
houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

--- Using Recusrion and Memoizaton ---------------------------
    
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return rec(nums, dp, 0);
    }
    public int rec(int[] nums,int[] dp, int i){
        if(i>= nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int steal= nums[i]+rec(nums,dp,i+2);
        int skip= rec(nums,dp,i+1);
        return dp[i]= Math.max(steal,skip);
    }
}

----------- Using Bottom-up approach -------------------------------
class Solution{
    public int rob(int[] nums) {
        if(nums.length ==1) return nums[0];
        int[] t = new int[nums.length];
        t[0] = nums[0];
        t[1] = nums[1];
        for(int i=2;i<=nums.length;i++){
            int steal = nums[i-1] + t[i-2];
            int skip = t[i-1];
            t[i] = Math.max(steal,skip);
        }
        return t[nums.length];
    }
}

----------------- Using constant space ----------------------------

class Solution {
    public int rob(int[] nums) {
        if(nums.length ==1 ) return nums[0];
        int prev2=0;
        int prev1= nums[0];
        for(int i=2;i<=nums.length;i++){
            int steal = nums[i-1]+ prev2;
            int skip = prev1;
            int curr = Math.max(steal,skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
    
