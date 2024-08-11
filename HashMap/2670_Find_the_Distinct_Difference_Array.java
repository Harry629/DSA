class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        HashMap<Integer,Integer> prefix = new HashMap<>();
        HashMap<Integer,Integer> suffix = new HashMap<>();
        int[] ans = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] suff = new int[nums.length];
         
        int k=0;
        int x =0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=i;j++){
                if(!prefix.containsKey(nums[j])){
                    prefix.put(nums[j],1);
                }
            }
            int pre_val = prefix.size();
            
            for(int j=i+1;j<nums.length;j++){
                if(!suffix.containsKey(nums[j])){
                    suffix.put(nums[j],1);
                }
            }
            int suf_val = suffix.size();
            prefix.clear();
            suffix.clear();
            ans[i]=pre_val-suf_val;
        }
        return ans;
    }
}
