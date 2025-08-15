You are given an array of words where each word consists of lowercase English letters.
wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal
to wordB.
For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single
word is trivially a word chain with k == 1.
Return the length of the longest possible word chain with words chosen from the given list of words.
  Example 1:

Input: words = ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: One of the longest word chains is ["a","ba","bda","bdca"].

class Solution {
    int n;
    int[][] t = new int[1001][1001];
    public boolean isPred(String prev,String curr){
        if(prev.length() >= curr.length() || (curr.length()-prev.length())!= 1)
            return false;
        int i=0,j=0;
        while(i<prev.length() && j<curr.length()){
            if(prev.charAt(i) == curr.charAt(j)){
                i++;
            }
            j++;
        }
        return i == prev.length();
    }
    public int lis(String[] words, int idx, int prev){
        if(idx == n)
            return 0;
        if(prev != -1 && t[prev][idx] !=-1){
            return t[prev][idx];
        }
        int taken =0;
        if(prev == -1 || isPred(words[prev], words[idx])){
            taken = 1 + lis(words, idx+1, idx);
        }
        int notTaken = lis(words, idx+1, prev);
        if(prev != -1) {
            t[prev][idx] = Math.max(taken, notTaken);
        }
        return Math.max(taken, notTaken);
    }
    public int longestStrChain(String[] words) {
        for(int i=0;i<words.length;i++){
            Arrays.fill(t[i],-1);
        }
        n = words.length;
        Arrays.sort(words, (s1,s2)-> Integer.compare(s1.length(), s2.length()));
        return lis(words, 0, -1);
    }
    
}
