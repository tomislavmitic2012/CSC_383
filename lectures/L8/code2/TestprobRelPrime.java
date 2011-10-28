import java.util.*;
import java.io.IOException;


public class TestprobRelPrime
{
    public static void main( String [ ] args )
    {
        Scanner sc = new Scanner(System.in) ;
        int x;
        

        System.out.println( "Enter an integer: " );
        try
        {
            x = sc.nextInt( );
            
            long start = System.currentTimeMillis() ;
            double prob = probRelPrime(x) ;
            long end = System.currentTimeMillis() ;

            System.out.println( "The probability of two numbers less than " + x + " are relative prime is  " + prob );
             System.out.println("The running time = " + (end - start) + " miliseconds") ;
        }
        
        catch( NumberFormatException e )
          { System.out.println( e ); }
    }


  public static int gcd( int m, int n )
        {
             if ( m < n ) return gcd(n,m) ;
             if ( n == 0 ) return m ;
              if ( n == 1 ) return 1 ;
             
               return gcd(n, m%n) ;
        }



   public static double probRelPrime(long n)
  {
    int rel = 0 , tot = 0 ;
  
     for ( int i  = 1 ; i  <= n ; i++ )
         for ( int j = i+1 ; j <= n ; j++ ) {
              tot++ ;
              if ( gcd(i,j) == 1 )   rel++ ;
         }
     return (double) rel / tot ;
  }
}
