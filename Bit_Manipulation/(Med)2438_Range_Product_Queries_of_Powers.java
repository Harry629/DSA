Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing
order, and there is only one way to form the array.
You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all 
powers[j] with lefti <= j <= righti.
Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] 
should be returned modulo 109 + 7.

  class Solution {
    public int[] productQueries(int n, int[][] queries) {
        ArrayList<Integer> powers = new ArrayList<>();
        for(int i=0;i<32;i++){
            if((n&(1<<i))!=0){
                powers.add(1<<i);
            }
        }
        int[] arr = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            long sum =1;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                sum = (sum*powers.get(j))%1000000007;
            }
            arr[i]= (int)sum;
        }
        return arr;
    }
}
