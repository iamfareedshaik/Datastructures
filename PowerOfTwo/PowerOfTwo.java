class PowerOfTwo{
    public static boolean method1(int n){
        if(n==0){
            return false;
        }
        while(n!=1){
            if(n%2 !=0){
                return false;
            }
            n = n/2;
        }

        return true;
    }

    public static boolean method2(int n){
        if(n==0){
            return false;
        }
        return ((n&(n-1)) == 0); // n&&(n&(n-1) == 0)
    }

    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        if(method2(n)){
            System.out.print("Yes");
        }else{
            System.out.print("No");
        }
    }
}