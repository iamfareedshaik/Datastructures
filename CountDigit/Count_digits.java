public class Count_digits{
    public int countDigits;
    
    public static String countDigitsWithargs(String input){
        try{
            int number = Integer.parseInt(input);
            if(number > 0)
                return ""+input.length();
            else{
                throw new Exception("Invalid input , must be greater than zero");
            }
        }catch(Exception e){
            System.out.print("Found Exception "+ e);
            return input;
        }
    }
    public static String countDigitswithint(int input){
        int count = 0;
        while(input > 0){
            count = count + 1;
            input = input/10; 
        }
        return ""+count;
    }
    public static void main(String args[]){
        String input = args[0];
        String inputFormat = args[1];
        try{
            if(inputFormat.equals("string")){
                System.out.print("Digits count with type string "+countDigitsWithargs(input));
            }
             else{
                System.out.print("Digits count with type Integer" + countDigitswithint(Integer.parseInt(input)));
            }
        } catch(Exception e){
            System.out.print("Found exception "+ e);
        }
   
    }
}