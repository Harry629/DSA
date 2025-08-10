You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
Return true if and only if we can do this so that the resulting number is a power of two.

 class Solution {
    HashSet<String> hs = new HashSet<>();
    void buildSet(){
        for(int i=0;i<=29;i++){
            String s = Integer.toString(1<<i);
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String st = new String(ch);
            hs.add(st);
        }
    }
    public boolean reorderedPowerOf2(int n) {
        if(hs.isEmpty()){
            buildSet();
        }
        String st = Integer.toString(n);
        char[] ch = st.toCharArray();
        Arrays.sort(ch);
        String ans = new String(ch);
        if(hs.contains(ans)) return true;
        return false;
    }
}
