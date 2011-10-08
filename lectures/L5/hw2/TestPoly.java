
import java.util.*;

class TestPoly{

    static Polynomial qq ;
    static Polynomial rr ;

    public static void main(String [] args) {
    
    long [] a1 = { 3,1 ,  2, -1, 1, 1 , 0, -1} ;
    long [] b1 = {3,-1 , 2, 1 , 1, -1, 0, 1} ;
    long [] c1 = { 2,1,0,-1} ;

    Polynomial poly1 = new Polynomial(a1) ;
    Polynomial poly2 = new Polynomial(b1) ;
    Polynomial poly3 = new Polynomial(c1) ;

     System.out.print("poly1 : ") ;
     System.out.println(poly1) ;

     System.out.print("\npoly2 : ") ;
     System.out.println(poly2) ;

      System.out.print("\npoly3 : ") ;
     System.out.println(poly3) ;


     Polynomial poly4 = Polynomial.add(poly1, poly2) ;

     System.out.print("\n\npoly1 + poly2 = " ) ;
    
     System.out.println(poly4) ;

       Polynomial poly5 = Polynomial.add(poly1, poly3) ;
     System.out.print("\npoly5 =  poly1 + poly3 = " ) ;
     System.out.println(poly5) ;
    
     poly4 = Polynomial.negate(poly5) ;

     System.out.print("\n - poly5 = " ) ;
     System.out.println(poly4) ;


    
     Polynomial poly6 = Polynomial.subtract(poly1,poly5) ;
     System.out.print("\n\npoly6 = subtract(poly1,poly5) = ") ;
  
     System.out.println(poly6) ;


     Polynomial poly7 = Polynomial.derivative(poly6) ;
     System.out.print("\n\nderivative of poly6 = ") ;

     System.out.println(poly7) ;
    

      Polynomial  poly8 = Polynomial.multiply(poly3, poly3) ;

      System.out.print("\n\nmultiply(poly3, poly3) = ") ;
         System.out.println(poly8) ;

      Polynomial  poly9 = Polynomial.multiply(poly1, poly2) ;

      System.out.print("\n\npoly9 = multiply(poly1, poly2) = ") ;
      System.out.println(poly9) ;

     
     System.out.println("\n\nmultiply(poly1, poly3) = " + Polynomial.multiply(poly1, poly3) ) ;

      System.out.println("\n\nmultiply(poly3, poly1) = " + Polynomial.multiply(poly3, poly1) ) ;


            


      Polynomial q = Polynomial.divide(poly9, poly3) ;
      Polynomial r = Polynomial.mod(poly9, poly3) ;

      System.out.println("\n\nQuotient of divide(poly9, poly3) = " + q ) ;
      System.out.println("\n\nRemainder  (poly9/ poly3) = " + r ) ;
     


     System.out.println("\n\nPolynomial.divide(poly9, poly1) = " +  Polynomial.divide(poly9, poly1) ) ;

     System.out.print("\n\n" + poly1 + " and\n\n" + q );

    
      if ( poly1.equal(q)) System.out.println("  are the same!") ;
       else System.out.println("  are not the same !!") ;



       System.out.println("\n\nevaluate poly9(1) = " + poly9.eval(1)) ;
       System.out.println("\n\nevaluate poly9(2) = " + poly9.eval(2)) ;




   }


}