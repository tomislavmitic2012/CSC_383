class h2{

   public static int max(int [] A, int n){

          if ( n == 1 ) return A[0] ;

          int large = max(A,n-1) ;

          return (large > A[n-1] ? large : A[n-1]) ;

 


  }


   public static void maxmin(int [] A, int n , int [] result) {

         int max = result[0] = A[n-1] ;
         int min = result[1] = A[n-1] ;

         if ( n == 1 ) return ;


         int [] tmp = new int[2] ;
         
         maxmin(A,n-1,tmp) ;

         result[1] =(A[n-1] < tmp[1] ) ?  A[n-1] : tmp[1] ;
         result[0] = (A[n-1] > tmp[0]) ? A[n-1] : tmp[0] ;

       

   }

   public static void maxmin2(int [] A , int [] result) {
     int  i, j ;

      for (i=0, j = A.length-1 ; i < j ; i++, j-- )

          if ( A[i] > A[j] ) swap(A,i,j) ;
     
      // after n/2 comparision
      // left half of the array contains the smaller of two
      // right half contains the larger of two 

      int n = A.length ;

      int min = A[0] ;
      int max = A[n-1] ;

     for ( i = 1 ; i < n/2+1 ; i++ )
          if ( A[i] < min ) min = A[i] ;

     for (  i = n-2 ; i >= n/2 ; i-- )
        if (A[i] > max)  max = A[i] ;


      result[0] = max ;
      result[1] = min ;


   }

   public static void swap(int [] A, int x, int y) {

             int z =A[x] ;
             A[x] =A[y] ; A[y] = z ;
   }

   

   public static String reverse(String s) {

      int  n = s.length() ;

     if ( n == 0 || n == 1 ) return s ;

     char c = s.charAt(0) ;

     return reverse(s.substring(1)) + c ;



   }


    public static int convert(String s) {

      int n = s.length() ;


      if (s.length() == 1 ) return  (s.charAt(n-1) - '0' ) ;
     
     
      
      return 10*convert(s.substring(0,n-1)) +( s.charAt(n-1) - '0');


   }

    public static int compare(int x, int y ) {

          

          if ( x > y  ) return  1;
          else if ( x == y ) return  0 ;
               else return -1 ;

    }

   public static void main(String [] args) {


       int [] A = {1,2,35,4,31,22,23} ;

        for (int e: A) System.out.print(e + " ") ;
      

      System.out.println("\nmax = " + max(A, A.length)) ;

        List list = List.build(A) ;
        list.print() ;

        list.reverse() ;
        list.print() ;

        list.reverse2() ;
        list.print() ;

       System.out.println("The size of list = " + List.count(list) ) ;

        System.out.println("1234 = " + convert("1234") ) ;

       int [] R = new int[2] ;

       maxmin(A,A.length, R) ;

      System.out.printf("Max = %d and min = %d \n", R[0], R[1]) ;

      int [] RR = new int[2] ;

       maxmin2(A, RR) ;

      System.out.printf("Max = %d and min = %d \n", RR[0], RR[1]) ;

       String s = "pots&pans";

      System.out.printf("The reverse string of %s is %s \n\n",s , reverse(s)) ;


    }

}

class Node {

    public int data;
    public Node next ;

   public Node(int d) {
        data = d ;
       next = null ;
    }

   public Node (int d , Node N ) {
      data  = d ;
      next = N ;
   }

   public Node () {
     data = 0 ;
     next = null ;
   }

     public Node ( Node other) {

      data = other.data ;
      next = copy(other.next) ;
   }

   public static Node copy ( Node other) {

          if ( other  == null ) return  null ;
          Node tmp = new Node(other.data) ;
          other.next = copy(other.next) ;
          return tmp ;


   }


}

class List{

    public Node head ;
   
    public int size ;

    public  List () {
          head = null ;
          size = 0  ;
    }

    public List(Node N) {

        size = 1 ;
        head = new Node(N) ;
   }

   public List(List other) {

        if (other == null ) {
             head = null ;
             size = 0 ; 
        }
       else {
              size = other.size ;
              head = Node.copy(other.head) ;
      }
    }

   public static List build(int [] A ) {

        if ( A.length == 0 ) return null ;
      
        int n = A.length-1 ;

        Node tmp = new Node(A[n]) ;

        List list = new List(tmp) ;

        for ( int i = n -1 ; i >=0  ; i-- ){
                 tmp = new Node(A[i]) ;
                 list.addFront(tmp) ;
      
        }

	list.size = n+1 ;
        return list ;

   }

    public void addFront(Node N) {

          if ( N == null ) return ;
 
          Node temp = new Node(N.data ) ;
             temp.next = head ;
             head = temp ;
             

   }

    public void print() {

         Node tmp = head ;

        while ( tmp != null) {
             System.out.print(tmp.data+ " " ) ;
             tmp = tmp.next ;
        }

     System.out.println("\n");


    }

    public void reverse() {

         head =  reverse(head) ;

     }


     public Node reverse(Node N) {

        if ( N == null || N.next == null ) return N ;
        Node tmp = reverse(N.next) ;
        Node last = tmp ;

         while( last.next != null )  last = last.next ;

         last.next = new Node(N.data) ;

        return tmp ;
      
     }



    public void reverse2() {
          head = reverse2(head) ;
    }

    public Node reverse2(Node N) {


            
        if ( N == null || N.next == null ) return N ;

        Node pre = null;
        Node cur = N  ;
        Node nex = N.next ;


         while ( nex != null ) {


           cur.next = pre ;

           pre = cur ; cur = nex ; nex = nex.next ;
         }

         cur.next = pre ;
     
         N = cur ;
          return cur  ;


    }


    public static int count(Node N) {

      if ( N == null ) return 0 ;
      return 1+ count(N.next) ;

    }


    public static int count (List list) {

          if ( list == null ) return 0 ;
          return count(list.head) ;

    }
}