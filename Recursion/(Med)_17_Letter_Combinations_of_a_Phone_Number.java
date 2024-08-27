class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            ArrayList<String> arr = new ArrayList<>();
            return arr;
        }else{
            return combin("",digits);
        }
        
    }
    public ArrayList<String> combin(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<String>();
            ans.add(p);
            return ans;
        }
        int digit = up.charAt(0)-'0';
        int i= (digit-2)*3;
        if(digit>7){
            i=i+1;
        }
        int len = i+2;
        if(digit==7 || digit ==9){
            len += 1;
        }
        ArrayList<String> answ = new ArrayList<String>();
        for(int j =i;j<=len;j++){
            char ch = (char)('a'+j);
            answ.addAll(combin(p+ch,up.substring(1)));
        }
        return answ;
    }
}
