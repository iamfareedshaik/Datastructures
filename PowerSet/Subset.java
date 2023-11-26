class Subset{
    public static void main(String args[]){
        String input = args[0];
        int n = input.length();
        for(int i=0;i<(1<<n);i++){
            String output ="";
            for(int j=0;j<n;j++){
                if(((1<<j)&i)!=0){
                    output = output + input.charAt(j);
                }
            }
            System.out.println(output);
        }
    }
}