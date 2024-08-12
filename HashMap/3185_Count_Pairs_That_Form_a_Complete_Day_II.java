// 3185. Count Pairs That Form a Complete Day II

class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        long count=0;
        for(int n: hours){
            int rem =  n%24;
            int compl = (24-rem) %24;
            if(hm.containsKey(compl)){
                count += hm.get(compl);
            }
            hm.put(rem, hm.getOrDefault(rem,0)+1);
        }
        return count;
    }
}
