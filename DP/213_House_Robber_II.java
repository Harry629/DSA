// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor
// of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

class Solution {
    public int rob(int[] nums) {
        return dp(nums);
    }
    public int dp(int[] nums){
        
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length==3){
            return Math.max(nums[0],Math.max(nums[1],nums[2]));
        }
        else{    
            int[] dp1 = new int[nums.length-1];
            int[] dp2 = new int[nums.length-1];

            dp1[0]= nums[0];
            dp2[0] =nums[1];
            dp1[1]= Math.max(nums[0],nums[1]);
            dp2[1]=Math.max(nums[1],nums[2]);
            for(int i=2;i<nums.length-1;i++){
                dp1[i]= Math.max(dp1[i-1], nums[i]+dp1[i-2]);
            }
            for(int i=2;i<nums.length-1;i++){
                dp2[i]= Math.max(dp2[i-1], nums[i+1]+dp2[i-2]);
            }
            return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
        }
        
    }
}
