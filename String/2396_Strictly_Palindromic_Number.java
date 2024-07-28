// An integer n is strictly palindromic if, for every base b between 2 and n - 2 (inclusive), the string representation of the integer n in base b is palindromic.
// Given an integer n, return true if n is strictly palindromic and false otherwise.
// A string is palindromic if it reads the same forward and backward.

class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<n-1;i++){
            if(base(n,i)==false){
                return false;
            }
        }
        return true;
    }
    public boolean base(int n, int bnum){
        StringBuilder str = new StringBuilder();
        if(n==0){
            return false;
        }
        while(n>0){
            int rem = n%bnum;
            str.append(rem);
            n=n/bnum;
        }
        if(str.equals(str.reverse().toString())){
            return true;
        }else{
            return false;
        }
    }
}
