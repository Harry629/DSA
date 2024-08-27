import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        ArrayList<String> arr = perm("","abc");
        System.out.println(arr);
    }
    public static ArrayList<String> perm(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        char ch = up.charAt(0);
        ArrayList<String> fin = new ArrayList<String>();
        for(int i=0;i<p.length()+1;i++){
             String first = p.substring(0,i);
             String last = p.substring(i,p.length());
             fin.addAll(perm(first+ch+last,up.substring(1)));
        }
        return fin;
    }
}
