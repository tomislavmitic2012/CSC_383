import java.util.*;

 

class TestSort{

private static final int SIZE = 10000 ;


  

   public static void main(String[] args) {
        int size = SIZE ;
        long  start = 0 , end = 0 ;
         int type = 0  ;
           

         if (args.length > 0)  size = Integer.parseInt(args[0]);
         if ( args.length > 1 ) type = Integer.parseInt(args[1]) ;

        Integer [] a = new Integer[size];
        Integer [] temp = new Integer[size] ;
        java.util.Random rand =  new Random() ;


       if ( type == 0 ) {  // random order
         
      	  for (int i=0; i<size; i++) {
            a[i] = rand.nextInt(5*size )   ;
      	  }
        
        } else if ( type == 1 ) {  // already sorted in ascending order 

	   for (int i=0; i<size; i++) {
            a[i] = i   ;
      	  }

    	}  else if (type == 2) { // sorted in descending order

	   for (int i=0; i<size; i++) {
            	a[i] = size - i   ;
      	   }

    	}  else {   // all the data are the same

 	   for (int i=0; i<size; i++) {
            	a[i] = 1   ;
      	   }

    	} 

      Integer [] b =new Integer[size] ;
      System.arraycopy(a,0,b,0,size) ;

       String []Type = {"in Random order", " in ascending order", " in descending order ", " al the same "};

       System.out.printf("\n\nFor data set of size =  %d with data %10s \n\n" , size, Type[type]) ; 

          start = System.currentTimeMillis();

          Sort.heapSort(b) ;

         end = System.currentTimeMillis();

         sorted(b) ;
       
        System.out.printf("\t%-15s takes %10d ms \n\n", "heapSort",(end - start) ) ;

        System.arraycopy(a,0,b,0,size) ;
        start = System.currentTimeMillis();


        Sort.quicksort4(b);

        end = System.currentTimeMillis();

           sorted(b) ;
   
   
       System.out.printf("\t%-15s takes %10d ms \n\n", "Quicksort4",(end - start) ) ;


        System.arraycopy(a,0,b,0,size) ;
        start = System.currentTimeMillis();


          Sort.quicksort3(b);

        end = System.currentTimeMillis();

           sorted(b) ;
       
      System.out.printf("\t%-15s takes %10d ms \n\n", "Quicksort3",(end - start) ) ;

        System.arraycopy(a,0,b,0,size) ;
        start = System.currentTimeMillis();


        Sort.quicksort4(b);

        end = System.currentTimeMillis();

           sorted(b) ;
        
       System.out.printf("\t%-15s takes %10d ms \n\n", "Quicksort2",(end - start) ) ;

        System.arraycopy(a,0,b,0,size) ;
        start = System.currentTimeMillis();


        Sort.quicksort(b);

        end = System.currentTimeMillis();

           sorted(b) ;
      

       System.out.printf("\t%-15s takes %10d ms \n\n", "Quicksort",(end - start) ) ;



         Integer [] c = new Integer[size] ;

          System.arraycopy(a,0,b,0,size) ;

       
        start = System.currentTimeMillis();


         Sort.mergeSort(b,c);

        end = System.currentTimeMillis();




           sorted(b) ;

       System.out.printf("\t%-15s takes %10d ms \n\n", "mergeSort",(end - start) ) ;


       

/////////////////////////////////////// mergesort with switch  

         System.arraycopy(a,0,b,0,size) ;

       
        start = System.currentTimeMillis();


         Sort.mergeSort(b,c, 20);

        end = System.currentTimeMillis();




           sorted(b) ;
      

      System.out.printf("\t%-15s takes %10d ms \n\n", "mergeSort2",(end - start) ) ;



////////////////////////////////////  use of Arrays.sort()


         System.arraycopy(a,0,b,0,size) ;

       
        start = System.currentTimeMillis();


         Arrays.sort(b);

        end = System.currentTimeMillis();




           sorted(b) ;
      

      System.out.printf("\t%-15s takes %10d ms \n\n", "Arrays.sort",(end - start) ) ;


      

 if ( size > 20000 ) return ;  // if the size is too large , skip insertionsort, selectionSort and bubbleSort


////////////////////////  insertionSort   ///////////////////

        System.arraycopy(a,0,b,0,size) ;
        start = System.currentTimeMillis();


        Sort.insertionSort(b);

        end = System.currentTimeMillis();

           sorted(b) ;

        System.out.printf("\t%-15s takes %10d ms \n\n", "insertionSort",(end - start) ) ;


       


 ////////////////////////  selectionSort   ///////////////////

        System.arraycopy(a,0,b,0,size) ;
        start = System.currentTimeMillis();


        Sort.selectionSort(b);
        sorted(b) ;

        end = System.currentTimeMillis();

        System.out.printf("\t%-15s takes %10d ms \n\n", "selectionSort",(end - start) ) ;



////////////////////////  bubbleSort   ///////////////////

        System.arraycopy(a,0,b,0,size) ;
        start = System.currentTimeMillis();


        Sort.bubbleSort(b);

        end = System.currentTimeMillis();

           sorted(b) ;

        System.out.printf("\t%-15s takes %10d ms \n\n", "bubbleSort",(end - start) ) ;




        System.exit(0);
    }


   public static <T extends Comparable<? super T>> void sorted(T [] a) {

         for (int i=1; i<  a.length; i++) {
            if (a[i-1].compareTo(a[i]) > 0 ) {
                System.out.println("ERROR");
                System.exit(-1);
            }
        }

   }

   public static<T> void print(T [] a) {

         int  k = 0 ;
         for (T e : a) {
             System.out.print(e + " ; " ) ;
             k++ ;
             if ( k %8 == 0 ) System.out.println("") ;
         }

          System.out.println("\n\n") ;
   }
}