// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing
// the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.


// ---------------------------------Using Recursion and dp -----------------------------------------------------------------------------

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] charText1 = text1.toCharArray();
        char[] charText2 = text2.toCharArray();
        int[][] dp = new int[charText1.length+1][charText2.length+1];
        for(int i=0;i<=charText1.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return lCS(charText1,charText2, 0,0,dp);
    }
    public int lCS(char[] text1, char[] text2, int i, int j,int[][] dp){
        int take =0, c1=0, c2=0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i== text1.length || j==text2.length) return dp[i][j]= 0;
        if(i< text1.length && j< text2.length &&text1[i]==(text2[j])){
            take = 1 + lCS(text1, text2, i+1, j+1,dp);
        }
        if(i< text1.length){
            c1 = lCS(text1, text2, i+1, j,dp);
        }
        if(j< text2.length){
            c2 = lCS(text1, text2, i, j+1,dp);
        }
        return dp[i][j]=Math.max(take,(Math.max(c1, c2)));
    }
}

---------------------- Using tabulation ------------------------

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i=0;i<=n;i++){
            dp[i][m]= 0;
        }
        for(int j=0;j<=m;j++){
            dp[n][j]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j]= 1+ dp[i+1][j+1];
                }else{
                    dp[i][j]= Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];

    }
}
