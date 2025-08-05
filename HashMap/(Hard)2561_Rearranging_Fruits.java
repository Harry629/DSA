// You have two fruit baskets containing n fruits each. You are given two 0-indexed integer arrays basket1 and basket2 representing the cost of fruit in each basket. 
// You want to make both baskets equal. To do so, you can use the following operation as many times as you want:
// Choose two indices i and j, and swap the ith fruit of basket1 with the jth fruit of basket2.
// The cost of the swap is min(basket1[i], basket2[j]).
// Two baskets are considered equal if sorting them according to the fruit cost makes them exactly the same baskets.
// Return the minimum cost to make both the baskets equal or -1 if impossible.

-------------------------------------------------------------------------------
  
  class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = basket1.length;
        int gMin = Integer.MAX_VALUE;

        for(int i=0;i<n ;i++){
            hm.put(basket1[i], hm.getOrDefault(basket1[i],0)+1);
            hm.put(basket2[i], hm.getOrDefault(basket2[i],0) -1);
            gMin = Math.min(gMin, Math.min(basket1[i],basket2[i]));
        }

        List<Integer> excess=  new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry: hm.entrySet()){
            if(entry.getValue() %2 !=0) return -1;

            for(int i=0;i<Math.abs(entry.getValue())/2;i++){
                excess.add(entry.getKey());
            }
        }
        Collections.sort(excess);
        long cost =0;
        for(int i=0;i<excess.size()/2;i++){
            cost += Math.min(excess.get(i), 2* gMin);
        }
        return cost;
    }
}
