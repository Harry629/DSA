// 2610. Convert an Array Into a 2D Array With Conditions

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
            }else{
                hm.put(nums[i], hm.get(nums[i])+1);
            }
        }
        int maxRowCount =0;
        for(Integer key: hm.keySet()){
            maxRowCount = Math.max(maxRowCount, hm.get(key));
        }
        while(maxRowCount-->0){
            List<Integer> arr = new ArrayList<>();
            ans.add(arr);
        }
        hm.clear();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i],1);
                ans.get(0).add(nums[i]);
            }else{
                hm.put(nums[i],hm.get(nums[i])+1);
                ans.get(hm.get(nums[i])-1).add(nums[i]);
            }
        }
        return ans;
    }
}