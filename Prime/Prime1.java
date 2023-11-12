class Prime1{
    public static boolean checkPrime(int n){
        if(n == 1) return false;
        if(n == 2 || n == 3) return false;
        if(n%2 == 0 || n%3 == 0) return false;
        for(int i=5; i*i <= n; i = i+6){
                System.out.println(n);
                System.out.println(i);
                System.out.println(n%i);
            if(n%i == 0 || n%(i+2) == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        System.out.print(checkPrime(n));
    }
}