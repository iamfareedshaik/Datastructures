
class Gcd{

    public static int gcdProcess(int min, int num1, int num2){
        while(min > 0){
            if((num1 % min == 0) && (num2 % min == 0)){
                return min;
            }
            min = min -1;
        }
        return min;
    }

    public static int bestEcludian(int num1, int num2){
        if(num2 == 0)
            return num1;
        else
            return bestEcludian(num2, num1%num2);
    }
    public static int gcdRecursive(int min, int num1, int num2){
        if(min <= 1){
            return min;
        }
        if(num1 % min == 0 && num2 % min == 0)
            return min;
        return gcdRecursive(min-1, num1, num2);
    }

    public static int ecludianRec(int num1, int num2){
        if(num1 == num2){
            return num1;
        }
        if(num1 > num2){
            num1 = num1 - num2;
        }else{
            num2 = num2 - num1;
        }
        return ecludianRec(num1, num2);
    }

    public static void main(String args[]){
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int min = Math.min(num1, num2);
        int out = min;
        if(args[2].toLowerCase().equals("recursive")){
            out = gcdRecursive(min, num1, num2);
        }
        else if (args[2].toLowerCase().equals("ecludian")){
            out = ecludianRec(num1,num2);
        }
        else if (args[2].toLowerCase().equals("bestEcludian")){
            out = bestEcludian(num1,num2);
        }
        else{
            out = gcdProcess(min, num1, num2);
        }
        
        if(out < 1 ){
            System.out.print("Both numbers are not divisible");
        }else {
            System.out.print("Both numbers are divisble by " + out);
        }

    }
}