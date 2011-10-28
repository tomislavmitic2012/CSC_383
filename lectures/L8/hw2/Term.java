class Term {

    public long coef ;
    public long exp ;

    public char variable = 'X' ;

    public Term() {
           coef = 1 ;
           exp = 0 ;
    }
     public Term(long e , long c) {
            coef = c ;
            exp = e ;
     }
     
    public Term(long e , long c , char v) {
           coef = c  ; 
           exp = e ;
           variable = v ;
    }

    public boolean equal(Term other) {

       if ( other == null  ) return false ;
       if ( exp != other.exp || coef != other.coef) return false ;
       return true ;

    }

    public String toString() {

         String out = "" ;

         if ( coef == 0 ) return "0" ;

         String sign =  ( coef > 0  ) ? " " : " - " ;
         String ex = (exp == 1 ) ? " " : (""+exp) ;

         String co  = ( Math.abs(coef)  == 1 ) ? "" : (""+ Math.abs(coef)) ;

           if ( exp == 0 ) {
                  if ( Math.abs(coef) == 1 ) return sign+ Math.abs(coef)  ;
                   else  return sign + co ;
           } else if (exp == 1 ) { 
                  
                  if ( Math.abs(coef) == 1 ) return sign + variable  ;
                   else  return sign + co + variable;
           } else {

                  return sign + co + variable + "^" + ex ;

           }


    }

   public int compareTo(Term other) {

       if ( exp > other.exp ) return 1 ;
       else if ( exp < other.exp ) return  -1 ;
        else return  0 ;

   }

}