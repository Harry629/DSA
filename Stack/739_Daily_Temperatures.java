class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[t.length];
        for(int i=0;i<t.length;i++){
            while(!st.isEmpty() && t[i]> t[st.peek()]){
                int idx = st.pop();
                arr[idx] = i-idx;
            }
            st.push(i);
        }
        return arr;
    }
}
