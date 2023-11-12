class Prime{
    public static boolean checkPrime(int arg1, int divisor){
        if(divisor == 0 || divisor == 1){
            return true;
        }
        if(arg1%divisor == 0)
            return false;
        return checkPrime(arg1, divisor-1);
    }

    public static void main(String args[]){
        int arg1 = Integer.parseInt(args[0]);
        System.out.print(checkPrime(arg1, arg1-1) ? arg1+"is a prime number" : arg1 + "is not a prime number");
    }
}