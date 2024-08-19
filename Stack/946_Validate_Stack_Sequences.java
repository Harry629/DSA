class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i=0,j=0;
        while(i<pushed.length && j<popped.length){
            if(pushed[i]!= popped[j]){
                st.push(pushed[i]);
                i++;
            }else if(pushed[i]==popped[j]){
                st.push(pushed[i]);
                st.pop();
                j++;
                while(!st.isEmpty() && st.peek()==popped[j]){
                    st.pop();
                    j++;
                }
                i++;
            }
        }
        while(i<pushed.length){
            st.push(pushed[i]);
            i++;
        }
        while(j<popped.length){
            if(st.peek()==popped[j]){
                st.pop();
                j++;
            }else{
                return false;
            }
        }
        return st.isEmpty();
    }
}
