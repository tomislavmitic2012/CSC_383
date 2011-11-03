import java.util.Scanner;

class test{
    static  String [ ] months = {"January", "February", "March", "April", "May",
                             "June", "July", "August", "September", "October", 
                             "November", "December" } ;

     public static void main(String [] args) {

         


        for(int  i = 0 ; i < months.length ; i++ ) {
                System.out.printf("%10s  hashcode = %10d : %10X\n", months[i],  months[i].hashCode(),months[i].hashCode()) ;
       }


     System.out.println("\n\nTest hashCode () from object class\n\n") ;
       S  [] Month = new S[24] ;

       for ( int  i = 0 ; i < 12 ; i++ ){
                    Month[i] = new S(months[i]) ;
		   Month[i+12] = new S(months[i]) ;
               }

        for(int  i = 0 ; i < Month.length ; i++ ) {
	     if ( i % 12 == 0 ) System.out.println("\n") ;
               System.out.printf("%10s  hashcode = %10d : %10X \n", Month[i].name,  Month[i].hashCode(), Month[i].hashCode()) ;
       }
   }


  static  class S{
      public String name ;

      public S() {
             name= "" ;
    }
     public S(String s) {
             name = s ;
    }
  }


}