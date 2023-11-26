class KthBit{
    public static void main(String args[]){
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int element = n >> (k-1);
        if((element&1) != 0){
            System.out.print("K th bit is set to true");
        }else{
            System.out.print("K th bit is doesnt set");
        }
    }
}