import java.util.*;
class test{


  public static void main(String []  args) {

    Scanner sc = new Scanner(System.in) ;

    String [] months = {"Jan", "Feb", "Mar", "Apr","May",  
         "Jun", "Jul","Aug", "Sep", "Oct", "Nov", "Dec"};
                      
    Integer [] days ={31,28,31,30,31,30,31,31,30,31,30,31};

     Queue <Integer> que = new Queue<Integer>() ;
     Queue <Double> que2 = new Queue<Double>() ;
     Queue <String> que3 = new Queue<String>() ;
     Queue <Pair<String,Integer>> que4 = new Queue<Pair<String,Integer>>() ;
     Pair <String, Integer> temp ;
    for ( int i = 0 ; i < 10 ; i++)
       que.enqueue(i) ;

    
    while( !que.isEmpty()) 
        System.out.print(que.dequeue() + "  ") ;
     System.out.println();

     for ( int i = 0 ; i < 10 ; i++)
       que2.enqueue(( double )i/(i+1)) ;

    
    while( !que2.isEmpty()) 
        System.out.printf("%5.4f " ,que2.dequeue() ) ;
     System.out.println();


     for ( int i = 0 ; i < 12 ; i++)
       que3.enqueue(months[i]) ;
    while( !que3.isEmpty()) 
        System.out.printf("%s\n" ,que3.dequeue() ) ;
     System.out.println();

      for ( int i = 0 ; i < 12 ; i++)
       que4.enqueue(new Pair(months[i],days[i])) ;
    while( !que4.isEmpty()) {
        temp = que4.dequeue() ;
        System.out.printf("%s  %2d\n" ,temp.first,temp.second ) ;

    }
     System.out.println();

   }





}