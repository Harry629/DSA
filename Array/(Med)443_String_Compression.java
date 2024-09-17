// Input: chars = ["a","a","b","b","c","c","c"]
// Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

class Solution {
    public int compress(char[] chars) {
        int ans=0;
        for(int i=0;i<chars.length;){
            char l = chars[i];
            int count =0;
            while(i<chars.length && chars[i]==l){
                ++count;
                ++i;
            }
            chars[ans++]=l;
            if(count>1){
                for(char c:String.valueOf(count).toCharArray()){
                    chars[ans++]=c;
                }
            }
        }
        return ans;
    }
}
