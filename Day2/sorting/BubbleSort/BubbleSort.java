class BubbleSort{
    public static void main(String args[]){
        int arr[] = {3, 2, 10, 4, 6, 8};

        for(int i =0;i<arr.length;i++){
            for(int j =i; j<arr.length;j++){
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}