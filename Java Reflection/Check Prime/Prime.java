import static java.lang.System.in ;
class Prime{
    
    
    public void checkPrime(int...nums){
 
            for(int n : nums){
                int factors =  0 ;
               
                for(int i = 2 ; i <= n/2 ; i++ ){
                    
                    if(n%i==0){
                       
                        factors++ ;
                    }
                    
                }
                
                if(factors == 0 && n!=1){
                    System.out.print(n + " ");
                }
                
            }
            System.out.println() ;
          }

}