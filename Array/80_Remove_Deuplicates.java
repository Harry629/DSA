// 80. Remove Duplicates from Sorted Array II

class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }

        int k=0;
        for(Integer i: hm.keySet()){
            if(hm.get(i)>=2){
                arr.add(i);
                arr.add(i);
                k=k+2;
            }
            else{
                arr.add(i);
                k=k+1;
            }
        }for(int i=0;i<arr.size();i++){
            nums[i]=arr.get(i);
        }
        return k;
    }
}
