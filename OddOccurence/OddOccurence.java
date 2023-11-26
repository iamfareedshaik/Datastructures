class OddOccurence{
    public static void method1(int[] input){
        for(int i=0;i<input.length;i++){
            int count = 0;
            for(int j=0;j<input.length;j++){
                if(input[i] == input[j]){
                    count++;
                }
            }
            if(count%2==0){
                System.out.println(input[i]);
                break;
            }
        }
    }
    public static void method2(int[] input){
        int res = 0;
        for (int num : input) {
            res = res^num;
        }
        System.out.println(res);
    }

    public static void main(String args[]){
        int[] array = new int[args.length];
        for(int i =0;i<args.length;i++){
            array[i] = Integer.parseInt(args[i]);
        }
        method2(array);
    }
}