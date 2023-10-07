class Palindrome{
    public static boolean checkPalinStr(String input){
        StringBuilder inputBuilder = new StringBuilder(input);
        return inputBuilder.equals(inputBuilder.reverse());
    }
    public static boolean checkPalinInt(int input){
        int backup = input;
        int number = 0;
        while(input > 0 ){
            number = number*10 + input%10;
            input = input/10;
        }
        return number == backup;
    }
    public static void main(String args[]){
        String type = args[1];
        try{
            if(type.toLowerCase().equals("string")){
                if(checkPalinStr(args[0])){
                System.out.print("Given Input is a Palindrome");
                }else{
                System.out.print("Given Input is not a Palindrome");
                }
            }else{
                int input = Integer.parseInt(args[0]);
                if(checkPalinInt(input)){
                    System.out.print("Given Input is a Palindrome");
                }else{
                System.out.print("Given Input is not a Palindrome");
                }
            }
           
        }catch(Exception e){
            System.out.print("Found Exception "+ e);
        }
    }
}