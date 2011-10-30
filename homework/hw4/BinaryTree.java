/** 
	class BinaryTree  <T extends Comparable<? super T>>

*/



import java.util.Stack;
import java.util.LinkedList;

import java.util.Queue;

public class BinaryTree <T extends Comparable<? super T>> {


   protected  TreeNode<T> root ;

   public TreeNode <T> get_root() { return root ;  }


/** 
	size() returns the total number of nodes in the tree

*/

   public int size() {

          return size(root) ;

        }

/**
	height() : returns the height of the tree
*/

   public int height() {

        return height(root) ;
   }


   private int size (TreeNode x ) {

          if (x  == null ) return 0 ;
       // complete this method by adding your code here
   }

   private int height(TreeNode x ) {

             if ( x == null) return 0 ;

                     
	// complete this method by adding your code here
   }

/**
		default constructor

*/
    public BinaryTree() {
         root = null ;
   }


/**
   	constructor creates a single node tree

*/
   public BinaryTree(TreeNode<T> node) {

        root = new TreeNode<T>(node) ;

   }


/**  
   copy constructor  

*/
   public BinaryTree(BinaryTree<T> other) {
     
     root = copy(other.get_root()) ;

   }


/** 
	helper function  for copy constructor

*/

   private TreeNode<T> copy( TreeNode<T> other) {


         if ( other == null ) return other ;

        // complete this method by adding your code here

   
   }

/**
	This constructor takes an array of nodes as parameter, and build a balance tree,
        using the middle element as the root , every node to theleft of the  middle element
	goes to the left subtree , every node to the right of the middle element , goes to
	the right subtree, recursively.

*/
   public BinaryTree(T [] nodes) {

         root = build(nodes) ;

   }

/**
	auxilary methods
*/
   TreeNode<T> build(T [] nodes) {

        return build(nodes, 0, nodes.length-1) ;

    }

   TreeNode<T> build(T [] nodes, int l , int r ) {

        if ( l == r ) 
         return new TreeNode<T>(nodes[l]) ;
        else if ( l > r ) return null ;
             else {
		int  m = (l+r) / 2;
                TreeNode<T> root = new TreeNode<T>(nodes[m]) ;
                root.left = build(nodes,l,m-1) ;
                root.right = build(nodes,m+1,r) ;
                return root ;

              }

    }





/** 
	This constructor takes preoder and inorder traversal sequence of the nodes, build the binary tree.

*/

  public BinaryTree(T [] pre, T [] in){

          root = rebuild(pre,in) ;

    }


/** 
	Help function that actual build the tree recursively
*/


    TreeNode <T>rebuild(T [] pre , T [] in) {


          return rebuild(pre, 0, pre.length-1, in, 0, in.length-1) ;


    }


    TreeNode <T>rebuild(T [] pre, int pre_i , int pre_j ,T [] in, int in_i , int in_j) {

    // complete this method by adding your code here

   } 

/** 
	helper function, return -1 if not found  , otherwise, the position of x in list between i  and j will be return
*/

 int index(T  x , T [] list, int i , int j ) {

 
    }

/** recursive inorder traversal
*/

     public void inorder() {
           inorder(root) ;
     }

     void inorder(TreeNode r) {

            if ( r == null ) return ;
            inorder(r.left) ;
            System.out.println(r.value) ;
            inorder(r.right) ;


      }
/** recursive inorder traversal with level number, parent node and children
*/

    public void inorder1() {

          inorder1(root, null, 0) ;

    }
          
    void inorder1(TreeNode r, TreeNode papa, int level) {

             if ( r == null ) return ;

         // complete this method by adding your code here

     }

/**  non-recursive version of inorder traversal
*/

  public  void inorder2( ) {  
        inorder2(root) ;
   }


    void inorder2(TreeNode r) {

         if ( r == null ) return ;

       TreeNode cur = r ;
       TreeNode prev = null ;

       Stack  <TreeNode> stk = new Stack<TreeNode>() ;

     // complete this method by adding your code here


   }

/** non-recursive preorder traversal
*/

       public void preorder2() {

          preorder2(root) ;

     }

       void preorder2(TreeNode r) {

         if ( r == null ) return ;

       TreeNode cur = r ;
       TreeNode prev = null ;

       Stack  <TreeNode> stk = new Stack<TreeNode>() ;

       
     // complete this method by adding your code here

   }

/** recursive preorder traversal
*/
  
     public void preorder() {

          preorder(root) ;

     }

     void preorder(TreeNode r) {

            if ( r == null ) return ;

            // complete this method by adding your code here

      }


/** recursive postorder traversal
*/

    public void postorder() {

          postorder(root) ;

     }

     void postorder(TreeNode r) {

            if ( r == null ) return ;

            
           // complete this method by adding your code here


      }


/** recursive postorder traversal, also display the  level # of each node
*/

        public void postorder(int n) {

          postorder(root, 0) ;

     }

     void postorder(TreeNode r, int n) {

            if ( r == null ) return ;

            
           // complete this method by adding your code here

      }


/** non-recursive postorder traversal , stack is used.
*/


   public void postorder2() {

          postorder2(root) ;

     }

     void postorder2(TreeNode r) {

            if ( r == null ) return ;

       TreeNode cur = r ;

       Temp temp;
       

       Stack  <Temp> stk = new Stack<Temp>() ;

       
      // complete this method by adding your code here

    }



/** print the tree by the level, using queue
*/


   public void bylevel() {

         bylevel(root) ;
   }

    
    void bylevel(TreeNode r) {

            if ( r == null ) return ;

            Queue<TreeNode> que = new LinkedList<TreeNode>();

            // complete this method by adding your code here

     }


/** print the tree by level with the level number
*/

   public  void bylevel2() {

         bylevel2(root) ;
   }

    
    void bylevel2(TreeNode r) {

            if ( r == null ) return ;

            Queue<Temp> que = new LinkedList<Temp>();

	 // complete this method by adding your code here
    
     }

/** print the tree by level,   both the level number and the parent node will also  being displayed.
*/

      public void bylevel3() {

         bylevel3(root) ;
   }

    
      void bylevel3(TreeNode r) {

            if ( r == null ) return ;

            Queue<Temp2> que = new LinkedList<Temp2>();

        // complete this method by adding your code here

     }


  }