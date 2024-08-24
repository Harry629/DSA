import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        System.out.println(subseq("","abc"));
    }
    public static ArrayList<String> subseq(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> lst = new ArrayList<>();
            lst.add(p);
            return lst;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseq(p+ch,up.substring(1));
        ArrayList<String> right = subseq(p,up.substring(1));
        left.addAll(right);
        return left;
    }
}
