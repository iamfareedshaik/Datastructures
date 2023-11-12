class PrimeFactor{
    public static boolean isPrime(int n){
        if( n == 2 || n == 3) return true;
        if( n % 2 == 0 || n % 3 == 0) return false;

        for(int i = 5 ; i*i < n ; i = i+6){
            if(n % i == 0 || n % (i+1) == 0 ){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        for(int i =2 ; i<n ;i++){
            if(isPrime(i)){
                int x = i;
                while(n%x == 0){
                    System.out.println(i);
                    x = x * i; // we are using this to check again multiple of i which is prime by itself will divisible?
                }
            }
        } 
    }
}