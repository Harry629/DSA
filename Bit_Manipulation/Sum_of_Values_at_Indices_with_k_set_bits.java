class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum=0;
        for(int i=0;i<nums.size();i++){
            if(bitcount(i)==k){
                sum += nums.get(i);
            }
        }
        return sum;
    }
    public int bitcount(int i){
        int count=0;
        while(i!=0){
            if((i&1)==1){
                count++;
            }
            i=i>>1;
        }
        return count;
    }
}