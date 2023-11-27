class Binary{
    public static void binaryConv(int n){
        if(n==0){
            return;
        }
        binaryConv(n/2);
        System.out.print(n%2);
        
    }

    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        binaryConv(n);
    }
}