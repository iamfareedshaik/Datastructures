class CountSetBits{
    public static void method1(int n){
        int res = 0;
        while(n>0){
            if(n%2 == 1){ // res = res + n&1    (since any number & with 1 is 1)
                res++;
            }
            n = n/2;
        }
        System.out.println(res);
    }
    
    public static void method2(int n){
        int res = 0;
        while(n>0){
            n = n&(n-1);
            res = res + 1;
        }
        System.out.println(res);
    }

    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        method1(n);
        method2(n);
    }
}