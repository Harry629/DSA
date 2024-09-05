
class HelloWorld {
    public static void main(String[] args) {
       // System.out.println(count(4,4));
    }
  // ========== To count the number of possible ways to reach the end of the maze/matrix (Right,Down)===========================
    public static int count(int r, int c){
        if(r==1 || c==1){
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r,c-1);
        
        return (right + left);
    }
  // =============== To print all the paths taken to reach the destination (Right,Down) =======================================
  public static void count(String p,int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return ;
        }
        if(r>1){
            count(p+'D',r-1, c);    
        }
        if(c>1){
            count(p+'R',r,c-1);    
        }
    }
  // ==================== To return all the paths in an ArrayList (Right,Down) =============================================
  public static ArrayList<String> count(String p,int r, int c){ 
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(count(p+'D',r-1, c));    
        }
        if(c>1){
            list.addAll(count(p+'R',r,c-1));    
        }
        return list;
    }
  // ================== To count the number of possible ways if diagonal is allowed also (Right,Down,Diagonal) ====================
  public static int count(int r, int c){ 
        if(r==1 || c==1){
            return 1;
        }
        int left = count(r-1,c);
        int mid=0;
        if(r>1 && c>1)
            mid = count(r-1,c-1);
        int right = count(r,c-1);
        
        return (left + right+mid);
    }
  // ==============================To return all the paths in an ArrayList (Right,Down,Diagonal)====================
  public static ArrayList<String> count(String p,int r, int c){ 
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(r>1 && c>1){
            list.addAll(count(p+'D',r-1,c-1));
        }
        if(r>1){
            list.addAll(count(p+'V',r-1, c));    
        }
        if(c>1){
            list.addAll(count(p+'H',r,c-1));    
        }
        return list;
    }
  ======================== if there is some restrictions ===========================================
  // public static void main(String[] args) {
  //       boolean[][] maze= {
  //           {true, true, true},
  //           {true, false, true},
  //           {true, true, true},
  //           {true, true, true}
  //       };
  //       count("",maze, 0,0);
  //   }
    public static void count(String p,boolean[][] maze,int r, int c){ 
        if(r== maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            count(p+'V', maze, r+1, c);
        }
        if(c<maze[0].length-1){
            count(p+'H',maze, r,c+1);
        }
    }
}
