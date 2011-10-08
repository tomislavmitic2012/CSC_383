import java.util.*;
class test0{


  public static void main(String []  args) {

    Scanner sc = new Scanner(System.in) ;

    String [] months = {"Jan", "Feb", "Mar", "Apr","May",  
         "Jun", "Jul","Aug", "Sep", "Oct", "Nov", "Dec"};
                      
    Integer [] days ={31,28,31,30,31,30,31,31,30,31,30,31};

     Stack <Integer> stack1 = new Stack<Integer>() ;
     Stack <Double> stack2 = new Stack<Double>() ;
     Stack <String> stack3 = new Stack<String>() ;
     Stack <Pair<String,Integer>> stack4 = new Stack<Pair<String,Integer>>() ;
     Pair <String, Integer> temp ;
    for ( int i = 0 ; i < 10 ; i++)
       stack1.push(i) ;

    
    while( !stack1.isEmpty()) 
        System.out.print(stack1.pop() + "  ") ;
     System.out.println();

     for ( int i = 0 ; i < 10 ; i++)
       stack2.push(( double )i/(i+1)) ;

    
    while( !stack2.isEmpty()) 
        System.out.printf("%5.4f " ,stack2.pop() ) ;
     System.out.println();


     for ( int i = 0 ; i < 12 ; i++)
       stack3.push(months[i]) ;
    while( !stack3.isEmpty()) 
        System.out.printf("%s\n" ,stack3.pop() ) ;
     System.out.println();

      for ( int i = 0 ; i < 12 ; i++)
       stack4.push(new Pair(months[i],days[i])) ;
    while( !stack4.isEmpty()) {
        temp = stack4.pop() ;
        System.out.printf("%s  %2d\n" ,temp.first,temp.second ) ;

    }
     System.out.println();

 
  }
}