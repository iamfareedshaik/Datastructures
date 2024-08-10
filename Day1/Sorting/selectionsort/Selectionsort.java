class Selectionsort{
    public static void main(String args[]){
        int arr[] = {2,9, 10, 6, 3, 2, 4, 10};
        
        for(int i=0;i<arr.length;i++){
            int index = min(arr, i);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "->");
        }
    }

    public static int min(int arr[], int i){
        int min = arr[i]; 
        int index = i;
        for(int k =i+1; k< arr.length;k++){
            if(arr[k] < min){
                min = arr[k];
                index = k;
            }
        }
        return index;
    }
}