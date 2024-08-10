class InsertionSort{
    public static void main(String args[]){
        int arr[] = {2,9, 10, 6, 3, 2, 4, 10};

        for(int i =1;i<arr.length;i++){
            int j = i;
            int temp = arr[j];
            while(j>0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }

        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + "->");
        }

    }
}