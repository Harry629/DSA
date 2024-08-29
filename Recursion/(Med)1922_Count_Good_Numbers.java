class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1000000007;
        long odd = pow(4, n/2, mod);
        long even=  pow(5, n-(n/2),mod);
        return (int)((even*odd)%mod);
    }
    public long pow(long x, long n, long mod){
        if(n==0){
            return 1;
        }
        long half= pow(x, n/2,mod);
        if(n%2==0){
            return (half*half)%mod;
        }else{
            return (half*half*x)%mod;
        }
    }
}
