class Bubblesort{
    public static void main(String args[]){
        int arr[] = {2,10,5,17,4,9,2,0};
        int temp;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i =0;i< arr.length;i++){
            System.out.print(arr[i] + "->");
        }
    }
}