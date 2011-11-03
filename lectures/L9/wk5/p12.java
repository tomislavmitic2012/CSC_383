class p12{


   static  int mystry(int n) {
                if  ( n == 0 ) return 0 ;
                return 1+ mystry(n/2) ;
          }

  static int mystry11(int n) {
                if ( n == 0 || n ==  1)  return 1 ;
                return mystry11(n-1)+mystry11(n-2) ;
           }


    public static void main(String [] args) {

     int [] A = { 1,2,4,8,16,32,1024, 2048, 100} ;

    for (int i = 0 ; i < A.length ; i++ ){

       System.out.printf("mystry(%d) = %d\n", A[i], mystry(A[i])) ;

    }

   for (int i = 0 ; i < 40 ; i++ ){

       System.out.printf("mystry(%d) = %d\n", i, mystry11(i)) ;

    }

   }

}