
class Lcm{

    public static int lcmProcess(int min, int num1, int num2){
        System.out.print(min%num1);
        System.out.println(min%num2);
        if(min%num1 == 0 && min%num2 ==0){
            return min;
        }else{
        min = min + 1;
         return lcmProcess(min, num1, num2);
        }
    }

    public static void main(String args[]){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int min;
        if(num1 < num2){
            min = num1;
        }else{
            min = num2;
        }
        System.out.print("Least common Factor is "+ lcmProcess(min, num1, num2));
    }
}