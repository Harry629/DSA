
import java.util.*;
// tabulation
public class Main
{
    public static int fibo(int n){
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else{
            int arr[] = new int[n+1];
            arr[0]=0;
            arr[1]=1;
            for(int i=2;i<=n;i++){
                arr[i]=arr[i-1]+arr[i-2];
            }
            return arr[n];
        }
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n= sc.nextInt();
		System.out.println(fibo(n));
	}
}
