class Factorial{

    public static int factorialnum(int n){
        if(n < 1){
            return 1;
        }
        return n * factorialnum(n-1);
    }

    public static void main(String args[]){
        try{
            int input = Integer.parseInt(args[0]);
            if(args[1].equals("forloop")){
                int sum =0;
                for(int i =1;i<=input;i++){
                    sum = sum + i;
                }
                System.out.print(sum);
            } else {
                System.out.print(factorialnum(input));
            }
        } catch (Exception e){
            System.out.print("Exception found" + e);
        }
    }
}