class TwoOdd{

    public static void main(String args[]){
        int arr[] = new int[args.length];
        for(int i =0;i<args.length;i++){
            arr[i] = Integer.parseInt(args[i]);
        }
        int res = arr[0];
        for(int i =1;i<args.length;i++){
            res = res^arr[i];
        }

        res = res & -res;
        int res1 = 0;
        int res2 =0;
        for(int i=0;i<args.length;i++){
            if((res&arr[i])!=0){
                res1 = (res1^arr[i]);
            }else{
                res2 = (res2^arr[i]);
            }
        }
        System.out.print(res1);
        System.out.print(res2);

    }
}