/**
   TreeNode class serves as the  Node for the binary tree.

*/


public class TreeNode<T extends Comparable<? super T>>{
    T  value;
    TreeNode <T> left ;
    TreeNode <T> right;
       
    public T get_val() { return value;}
    public TreeNode <T>get_left() { return left ; }
    public TreeNode <T>get_right() { return right; }

    public void set_val(T val ) { value = val ; }
    public void set_Left(TreeNode<T> x) { left = x ; }
    public void setLeft(T x) {
          TreeNode<T> node = new TreeNode<T>(x) ;
          left = node ;
     }

    public void set_right(T x) {
        right = new TreeNode<T>(x) ;
   }
    public void set_right(TreeNode<T> x) { right = x ; }

    public TreeNode(){
           value = null ;
           left = null ;
           right = null ;
    }

    public TreeNode(T val) {
           value = val  ;
           left = null ;
           right = null ;
    }

    public TreeNode(TreeNode<T> other) {
           value = other.get_val() ;
           left = other.get_left() ;
           right = other.get_right() ;
    }

    public String toString() {
          String tmp = ""+  value  ;
          return tmp ;
    }   
}


/** 
	Temp is used for stack / queue , consist of  TreeNode and integer 
*/

class Temp {

    TreeNode tnode ;
    int n ;

    public Temp(TreeNode node , int x ) {
           tnode =  node ;
           n = x ;
   }
   
   public TreeNode get_node() { return tnode ; }
   public int get_n() { return n ; }

   public void set_n(int n ) {
        this.n = n ; 
   }
}

/**   consists of a pair of TreeNode and an integer
*/

 class Temp2 {

    TreeNode tnode1, tnode2 ;
    int n ;

    public Temp2(TreeNode node1 , TreeNode node2, int x ) {
           tnode1 =  node1 ;
           tnode2 =  node2 ;
           
           n = x ;
   }
   
   public TreeNode get_node1() { return tnode1 ; }
   
   public TreeNode get_node2() { return tnode2 ; }

   public int get_n() { return n ; }

   public void set_n(int n ) {
        this.n = n ; 
   }
}
