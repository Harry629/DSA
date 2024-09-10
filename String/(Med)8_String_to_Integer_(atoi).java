class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.length()==0) return 0;
        int sign =1;
        int i=0;
        char c = s.charAt(0);
        if(c=='-'){
            sign=-1;
            i++;
        }else if(c=='+'){
            i++;
        }
        long sum=0;
        while(i<s.length()){
            char curr= s.charAt(i);
            if(curr<'0' || curr>'9') break;
            int a = curr-'0';
            sum = sum*10 +a;

            //check for overflow condition 
            if(sign==1 && sum>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && -sum<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(sign*sum);
    }
}
