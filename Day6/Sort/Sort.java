import java.util.*;
class Sort{
    public static void bubble(){
        int arr[] = {7,2,0,1,34,8};
        for(int i =0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void selectionSort(){
        int arr[] = {7,2,0,1,34,8};
        for(int i=0;i<arr.length;i++){
            int index = findMin(arr, i);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        
        for(int i = 0;i< arr.length;i++){
            System.out.print(arr[i]);
        }


    }

    public static int findMin(int arr[], int j){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=j;i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void insertion(){
        int arr[] = {7,2,0,1,34,8};
        
        for(int i=1;i<arr.length;i++){
            int j =i-1;
            int temp = arr[i];
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;
        }
        
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static void mergeSort(){
        int arr[] = {7,2,0,1,34,8};
        merge(arr, 0 , arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static void merge(int arr[], int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            merge(arr,low, mid);
            merge(arr, mid+1, high);
            merging(arr,low, mid, high);    
        }
    }

    public static void merging(int arr[], int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i =0 ;i<n1;i++){
            arr1[i] = arr[low + i];
        }

        for(int i=0;i < n2 ; i++){
            arr2[i] = arr[mid+1+i];
        }
        int i=0; int j=0;
        int k =low;

        while(i<n1 && j<n2){
            if(arr1[i] <=  arr2[j]){
                arr[k] = arr1[i];
                k++;
                i++;
            } else{
                arr[k] = arr2[j];
                k++;
                j++; 
            }
        }

        while(i < n1){
            arr[k] = arr1[i];
            k++;
            i++;
        }

        while(j < n2){
            arr[k] = arr2[j];
            k++;
            j++;
        }

    }

    public void quicksort(){
        int arr[] = {7,2,0,1,34,8};
        quick(arr, 0, arr.length);
    }

    void quick(int arr[], low, high){
        if(low < high){
            int index = partition(arr, low, high);
            quick(arr, low, index);
            quick(arr, inde+1, high);
        }
    }

    void partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j< high;j++){
            if(arr[j] <= pivot){
                int temp = arr[j];
                arr[j] = arr[i]
                arr[i] = temp;
                i++;
            }
        }
        arr[i] = pivot;
    }

    public static void main(String args[]){
        // bubble();
        // selectionSort();
        // insertion();
        // mergeSort();
        quicksort();
    }
}