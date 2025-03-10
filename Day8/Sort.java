class Sort{

    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            int minIndex = getIndex(arr,i);
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static int getIndex(int arr[], int j){
        int index = j;
        int maxValue = Integer.MAX_VALUE;
        for(int i=j;i<arr.length;i++){
            if(arr[i] < maxValue){
                index = i;
                maxValue =arr[i];
            }
        }
        return index;
    }

    public static void insertionSort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            int key = arr[i];
            while(j>0 && arr[j]> key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    public static void quickSort(int arr[], int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr,pi+1, high);
        }    
        
    }

    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j = low;j<high;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static void main(String args[]){
        int arr[] = {2,9,19,3,5,10};
        quickSort(arr,0,arr.length-1);
    }   
}