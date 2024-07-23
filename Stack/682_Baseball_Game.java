// 682. Baseball Game

class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<op.length;i++){
            if(op[i].equals("C")){
                st.pop();
            }else if(op[i].equals("D")){
                st.push(2*st.peek());
            }else if(op[i].equals("+")){
                int num1 = st.pop();
                int num2= st.peek();
                st.push(num1);
                st.push(num1+num2);
            }else{
                st.push(Integer.parseInt(op[i]));
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum += st.pop();
        }
        return sum;
    }
}
