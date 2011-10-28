import java.util.*;

class Test {


     public static void main(String [] args) {


        String []  nodes = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
               "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} ;
      
         BinaryTree <String>tree = new BinaryTree<String>(nodes) ;

   	 process(tree) ;



         String [] pre ={"Jun", "Mar","Jan","Feb", "Apr", "May","Sep", "Jul",
                 "Aug", "Nov", "Oct", "Dec"} ;


         
         BinaryTree<String> tree2 = new BinaryTree<String>(pre, nodes) ;
 
         process(tree2) ;
      

         Integer [] num = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17} ;

         BinaryTree<Integer> tree3 = new BinaryTree<Integer>(num) ;
         process(tree3) ;

     }


     public static <T extends Comparable<? super T>> void process(BinaryTree<T> tree) {


	 System.out.println("\nThe height of the tree = " + tree.height() );
         System.out.println("\nThe size of the tree = " + tree.size() );

	 
         System.out.println("\n Tree : inorder :\n\n");

          tree.inorder() ;

	 System.out.println("\n Tree : inorder1 :\n\n");

          tree.inorder1() ;

 
	 System.out.println("\n Tree : inorder2 :\n\n");

          tree.inorder2() ;

	 System.out.println("\n Tree : preorder :\n\n");


          tree.preorder() ;

	  System.out.println("\n Tree : preorder2 :\n\n");


          tree.preorder2() ;

          
          System.out.println("\n\n Tree : postorder\n\n");
           tree.postorder() ;

          System.out.println("\n\n Tree : postorder2\n\n");
           tree.postorder2() ;
         


         System.out.println("\n\n Tree : postorder3\n\n");
         tree.postorder(0) ;
       
       
          System.out.println("\n\n Tree : by Level order\n\n");
           tree.bylevel() ;

            
          System.out.println("\n\n Tree : by Level order version 2\n\n");
           tree.bylevel2() ;

                   
          System.out.println("\n\n Tree : by Level order version 3\n\n");
            tree.bylevel3() ;


     }


}