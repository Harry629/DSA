Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.
An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of
the elements chosen are different.
The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
  
  class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr =0;
        for(int i:nums){
            maxOr |= i;
        }
        // int currOr=0;
        return count(0,nums,maxOr,0);
    }
    int count(int index,int[] nums, int maxOr,int currOr){
        if(index == nums.length){
            if(currOr == maxOr){
                return 1;
            }
            return 0;
        }

        //take nums[idx]
        int takeCount = count(index+1,nums,maxOr, currOr | nums[index]);

        //skip nums[idx]
        int skipCount = count(index+1,nums,maxOr,currOr);

        return takeCount + skipCount;
    }
}
