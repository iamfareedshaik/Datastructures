public class Count_digits{
    public int countDigits;
    
    public static int countDigitsWithargs(String input){
        return input.length();
    }
    public static int countDigitswithint(int input){
        int count = 0;
        while(input > 0){
            count = count + 1;
            input = input/10; 
        }
        return count;
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