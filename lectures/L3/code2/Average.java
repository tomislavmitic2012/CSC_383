import java.util.*;

class Average {


    public static double [] prefixAverages1(double [] X) {

            int n = X.length ;

            double [] A = new double[X.length] ;
   
              for (int i = 0 ; i <  n ; i++ ) {
                 double a = 0.0 ;

                 for ( int j = 0 ; j <= i ; j++ ) 

                  a = a + X[j] ;
                  A[i] =  a/(i+1) ;
              }

    
          return A ;


     }



    public static double [] prefixAverages2(double [] X) {

            int n = X.length ;

            double [] A = new double[X.length] ;
   
            double s = 0.0 ;
   
              for (int i = 0 ; i <  n ; i++ ) {
                 

                   s = s + X[i] ;

                       
                  A[i] =  s/(i+1) ;
              }

    
          return A ;


     }

   public static void main(String [] args) {

       
          Scanner sc =  new Scanner (System.in) ;

          System.out.print("Please enter any positive integer for the size of the array: ") ;

          int size = sc.nextInt() ;

          if ( size < 1 ) {
                  System.out.println("Size must be greater or equal to 1 !") ;
                  return ;
          }

          double [] Array = new double[size] ;
          double [] B = new double[size] ;
          double [] C = new double[size] ;

          Random  rand = new Random();

          for ( int i = 0 ; i < size ; i++ )

                   Array[i] = rand.nextDouble() ;

          long start = System.currentTimeMillis() ;

            B = prefixAverages1(Array) ;

          long end = System.currentTimeMillis() ;

         System.out.println("The running time for quadratic timeversion = " + (end - start) + " miliseconds") ;

         start = System.currentTimeMillis() ;

           C =  prefixAverages2(Array) ;


           end = System.currentTimeMillis() ;


            System.out.println("The running time forlinear time version = " + (end - start) + " miliseconds") ;


           if ( size < 20 ) {

             for ( int i = 0 ;i < size ; i++ )
               System.out.printf("%f %f    %f\n",Array[i],  B[i], C[i]) ;
           }

   }

   }