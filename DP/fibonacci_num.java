import java.util.*;
public class Main
{
    public static int fibo(int n, ArrayList<Integer> memo){
        if(memo.size()<=n){
            for(int i=1;i<=n;i++){
                memo.add(null);
            }
        }
        if(memo.get(n)!=null){
            return memo.get(n);
        }
        if(n<=2){
            memo.set(n,1);
        }
        else{
            int res= fibo(n-1,memo)+fibo(n-2,memo);
            memo.set(n,res);
        }
        return memo.get(n);
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		ArrayList<Integer> memo = new ArrayList<>();
		memo.add(0);
		System.out.println(fibo(n,memo));
	}
}