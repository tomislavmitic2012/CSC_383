import java.util.*;

class TestPower{

    public static long p(int x,  int n ) {

        if ( n == 0) return (long) 1 ;
        else return x*p(x,n-1) % 100000 ;
   }



    public static long Power(int x , int n) {
  
           long y = 1 ;

           if ( n == 0 ) return 1 ;

           if ( n % 2 == 1 ) {
                  y  = Power(x, (n-1)/2) ;
                 return  x*y*y  %  100000;
              }
            else {
                     y  = Power(x, n/2) ;
                    return y*y % 100000 ;
            }

   }


     public static void main(String[] args) {


                int b = 2 ;
                int exp = 1000 ;
                long result = 0 ;

              long start = System.currentTimeMillis() ;

            result  = p(b,exp) ;

          long end = System.currentTimeMillis() ;

         System.out.println("The running time for p = " + (end - start) + " miliseconds") ;


            start = System.currentTimeMillis() ;

            result  = Power(b,exp) ;

           end = System.currentTimeMillis() ;

          System.out.println("The running time for Power = " + (end - start) + " miliseconds") ;



   }



}