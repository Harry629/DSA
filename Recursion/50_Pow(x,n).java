class Solution {
    public double myPow(double x, int n) {
        double p=  pow(x,n);
        if(n<0){
            return 1/p;
        }else{
            return p;
        }
    }
    public double pow(double x, int n){
        int m = n;
        n = Math.abs(n);
        if(n==0){
            return 1.0;
        }
        if(x==0){
            return 0;
        }
        double ans = 1;
        ans = pow(x, n/2);
        if(n%2==0){
            return ans * ans;
        }else{
            return ans * ans *x;
        }
    }
}
