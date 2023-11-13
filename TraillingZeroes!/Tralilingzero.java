class Trailingzero{

    public static int factorial(int input){
        if(input<1){
            return 1;
        }
        return input * factorial(input - 1);
    }

    public static int countZeroes(int input){
        int count = 0;
        for(int i = 5 ; i <= input  ; i = i * 5){
            count = count + input /i; 
        }
        return count;
    }
    public static int countZ(int n){
        int sum =0;
        for(int i=5;i<=n;i=i*i){
            sum = sum + (n/i);
        }
        return sum;
    }

    public static void main(String args[]){

        int input = Integer.parseInt(args[0]);
        int factout = factorial(input);
        System.out.println(factout);
        int count = 0;
        while(factout % 10 == 0){
            count = count + 1;
            factout = factout / 10;
        }
        System.out.println(count);
        System.out.println("Count"+countZ(input));

    }
}