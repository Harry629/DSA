class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int minDis=0;
        int maxDis = nums[nums.length-1]-nums[0];

        while(minDis < maxDis){
            int midDis = minDis + (maxDis- minDis)/2;
            int pairs = countPairs(nums,midDis);
            if(pairs<k){
                minDis = midDis+1;
            }else{
                maxDis = midDis;
            }
        }
        return minDis;
    }
    public int countPairs(int[] nums, int target){
        int count =0;
        int left =0;
        for(int right =1;right<nums.length;right++){
            while(nums[right]-nums[left]>target){
                left++;
            }
            count += right-left;
        }
        return count;
    }
}
