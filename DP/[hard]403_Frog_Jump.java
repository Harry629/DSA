// A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The
// frog can jump on a stone, but it must not jump into the water.

// Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone.
// Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
// If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

class Solution {
    HashMap<Integer,Integer> hm = new HashMap<>();
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        int n= stones.length;
        if (stones.length < 2 || stones[1] != 1)
            return false;
        for(int i=0;i<stones.length;i++){
            hm.put(stones[i], i);
        }
        dp = new Boolean[n][n + 1];
        return caan(stones, 0, 1, 0);
    }
    public boolean caan(int[] nums, int curr,int next,  int k){
        int n = nums.length;
        boolean a = false, b= false, c= false;
        if(dp[curr][k] != null) return dp[curr][k];
        if(curr==n-1){
            return dp[curr][k]=true;
        }
        if(hm.containsKey(k+1+ nums[curr])){
            a  = caan(nums, hm.get(k+1+ nums[curr]),hm.get(k+1+ nums[curr])+1, k+1 );
        }
        if(k>0 && hm.containsKey(k+ nums[curr])){
            b = caan(nums,hm.get(k+ nums[curr]), hm.get(k+ nums[curr])+1,k);
        }
        if(k-1>0 && hm.containsKey(k-1+  nums[curr])){
            if(hm.get(k-1+ nums[curr]) > curr){
                c = caan(nums,hm.get(k-1+ nums[curr]), hm.get(k-1+ nums[curr])+1,k-1);
            }
        }
        return dp[curr][k]=a || b|| c;
    }
}
