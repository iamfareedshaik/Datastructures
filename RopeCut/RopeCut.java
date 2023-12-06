import java.util.*;

class RopeCut{
    public static int maxPieces(int n, int a, int b, int c){
        if(n == 0){
            return 0;
        }
        if(n<0){
            return -1;
        }
        int temp1 = maxPieces(n-a,a,b,c);
        int temp2 = maxPieces(n-b,a,b,c);
        int temp3 = maxPieces(n-c,a,b,c);
        int res = Math.max(temp1,Math.max(temp2,temp3));
        if(res<0){
            return -1;
        }
        return res + 1;
    }


    public static void main(String args[]){
        System.out.print(maxPieces(15,5,8,7));

    }
}