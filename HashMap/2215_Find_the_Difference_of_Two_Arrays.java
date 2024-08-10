
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> a1 = new ArrayList<>();
        List<List<Integer>> a3 = new ArrayList<>();
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        for(int i:nums2){
            hm1.put(i,1);
        }
        for(int i:nums1){
            if(!hm1.containsKey(i)){
                a1.add(i);
                hm1.put(i,1);
            }
        }
        a3.add(a1);
        hm1 = new HashMap<>();
        a1 = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            hm1.put(nums1[i],1);
        }
        for(int i:nums2){
            if(!hm1.containsKey(i)){
                a1.add(i);
                hm1.put(i,1);
            }
        }
        a3.add(a1);
        return a3;
    }
}
