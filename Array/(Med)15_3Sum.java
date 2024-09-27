// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
// and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// 1st Solution:->

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         HashSet<List<Integer>> hs = new HashSet<>();
//         for(int i=0;i<nums.length-1;i++){
//             Set<Integer> hashset = new HashSet<>();
//             for(int j=i+1;j<nums.length;j++){
//                 int k= -(nums[i]+nums[j]);
//                 if(hashset.contains(k)){
//                     List<Integer> temp = Arrays.asList(nums[i],nums[j],k);
//                     Collections.sort(temp);
//                     hs.add(temp);
//                 }
//                 hashset.add(nums[j]);
//             }
//         }
//         List<List<Integer>> arr= new ArrayList<>(hs);
//         return arr;
//     }

// 2nd Solution:-> (optimal approach)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k= nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> temp= Arrays.asList(nums[i],nums[j],nums[k]);
                    arr.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return arr;
    }
}
}
