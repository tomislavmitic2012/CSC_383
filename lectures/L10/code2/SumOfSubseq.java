import java.util.*;

class SumOfSubseq {


         static private int seqStart = 0;
         static private int seqEnd = -1;
   
   public static int maxSubSum1( int [ ] a ) {
         
       int maxSum = 0;

        for( int i = 0; i < a.length; i++ )
            for( int j = i; j < a.length; j++ ) {
 
             int thisSum = 0;

             for( int k = i; k <= j; k++ )
                 thisSum += a[ k ];

            if( thisSum > maxSum ) {
              maxSum = thisSum;
              seqStart = i;
              seqEnd = j;
              }
            }

        return maxSum;
     }



     public static int maxSubSum2( int [ ] a ){

        int maxSum = 0;

        for( int i = 0; i < a.length; i++ ){
             
            int thisSum = 0;

            for( int j = i; j < a.length; j++ ){
 
                thisSum += a[ j ];

               if( thisSum > maxSum ) {
                     maxSum = thisSum;
                     seqStart = i;
                     seqEnd = j;
                }
               }
          }

          return maxSum;
     }



      public static int maxSubSum3( int [ ] a ){

           int maxSum = 0;
           int thisSum = 0;

           for( int i = 0, j = 0; j < a.length; j++ ){

              thisSum += a[ j ];

              if( thisSum > maxSum ) {
                 maxSum = thisSum;
                 seqStart = i;
                 seqEnd = j;
              }
              else if( thisSum < 0 ){
                     i = j + 1;
                     thisSum = 0;
              }
             }

          return maxSum;
        }


     /**
     * Finds maximum sum in subarray spanning a[left..right].
     * Does not attempt to maintain actual best sequence.
     */
    public  static int maxSumRec( int [ ] a, int left, int right )
    {
        int maxLeftBorderSum = 0, maxRightBorderSum = 0;
        int leftBorderSum = 0, rightBorderSum = 0;
        int center = ( left + right ) / 2;

        if( left == right )  // Base case
            return a[ left ] > 0 ? a[ left ] : 0;

        int maxLeftSum  = maxSumRec( a, left, center );
        int maxRightSum = maxSumRec( a, center + 1, right );

        for( int i = center; i >= left; i-- )
        {
            leftBorderSum += a[ i ];
            if( leftBorderSum > maxLeftBorderSum )
                maxLeftBorderSum = leftBorderSum;
        }

        for( int i = center + 1; i <= right; i++ )
        {
            rightBorderSum += a[ i ];
            if( rightBorderSum > maxRightBorderSum )
                maxRightBorderSum = rightBorderSum;
        }

        return max3( maxLeftSum, maxRightSum,
                     maxLeftBorderSum + maxRightBorderSum );
    }

    /**
     * Return maximum of three integers.
     */
    private static int max3( int a, int b, int c )
    {
        return a > b ? a > c ? a : c : b > c ? b : c;
    }


     public static int maxSumRec( int [ ] a) {

            return  maxSumRec( a, 0, a.length-1 ) ;
        }

     public static void main(String[] args) {



           Random rand = new Random() ;
           int size = 10 ;

           if ( args.length == 1 )  size = Integer.parseInt(args[0]) ;

           int []  Array =  new int[size] ;


             for( int i = 0 ; i < size ; i++ ){
                Array[i] = rand.nextInt(100) ;
                if ( Array[i] % 3 == 1 ) Array[i] = -1* Array[i] ;
               }

                long start = 0  , end = 0  ;


              int result = 0 ;

              if (size < 10) {

                 for (int i = 0 ; i < size; i++ ) 
                      
                            System.out.print(Array[i]+ " ") ;

                 System.out.println();
               }

               start = System.currentTimeMillis() ;

               
                  result = maxSubSum3(Array) ;

                 end = System.currentTimeMillis() ;

                System.out.print("The result = " + result) ;

                System.out.println(" The running time for linear time version = " + (end - start) + " miliseconds") ;


            start = System.currentTimeMillis() ;

               
                  result = maxSubSum2(Array) ;

                 end = System.currentTimeMillis() ;

                System.out.print("The result = " + result) ;

                System.out.println(" The running time for quadratic time version = " + (end - start) + " miliseconds") ;


               start = System.currentTimeMillis() ;

               
                  result = maxSubSum1(Array) ;

                 end = System.currentTimeMillis() ;

                 System.out.print("The result = " + result) ;


                System.out.println(" The running time for cubic time version = " + (end - start) + " miliseconds") ;


            // test recursive version

                start = System.currentTimeMillis() ;

               
                  result = maxSumRec(Array) ;

                 end = System.currentTimeMillis() ;

                 System.out.print("The result = " + result) ;

                System.out.println(" The running time for recursive version = " + (end - start) + " miliseconds") ;












   }

}