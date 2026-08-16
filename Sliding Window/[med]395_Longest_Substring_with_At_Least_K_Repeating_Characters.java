Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this
substring is greater than or equal to k.
if no such substring exists, return 0.

------------------ recursion -----------------------

  class Solution {
    public int longestSubstring(String s, int k) {
        return longest(s,k, 0, s.length());
    }
    public int longest(String s, int k, int start, int end){
        if(end-start < k) return 0;

        int[] freq = new int[26];
        for(int i=start;i<end;i++){
            freq[s.charAt(i)-'a']++;
        }
        boolean isValid = true;
        for(int i=0;i<26;i++){
            if(freq[i]> 0 && freq[i]<k){
                isValid = false;
                break;
            }
        }
        if(isValid){
            return end-start;
        }
        int maxLen =0;
        int left = start;
        for(int right= start;right<end;right++){
            if(freq[s.charAt(right)-'a']<k){
                maxLen = Math.max(maxLen, longest(s,k , left, right));
                left = right+1;
            }
        }
        maxLen = Math.max(maxLen, longest(s,k, left, end));
        return maxLen;
    }
}
