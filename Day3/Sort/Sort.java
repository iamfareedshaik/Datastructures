class Sorting{
    void bubble(){
        int arr[] = {4,2,0,19,4,5,6};
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        print(arr);
    }

    void selection(){
        int arr[] = {4,2,0,19,4,5,6,12};
        for(int i =0;i<arr.length;i++){
            int index = min(arr, i);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        print(arr);
    }

    void insertion(){
        int arr[] = {4,2,0,1,4,5,6,12};
        for(int i =1;i<arr.length;i++){
            int j = i-1;
            int temp = arr[i];
            while(j>=0 && arr[j] > temp){
                arr[j+1] =arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        
        print(arr);
    }

    int min(int arr[], int i){
        int maximum = Integer.MAX_VALUE;
        int index = i;
        for(int j =i;j<arr.length;j++){
            if(arr[j] < maximum){
                maximum = arr[j];
                index = j;
            }
        }
        return index;
    }

    void print(int arr[]){
        for(int i=0;i<arr.length;i++ ){
            System.out.println(arr[i]);
        }
    }
    
    void merge(){
        int arr[] = {4,2,0,1,4,5,6,12,13};
        mergesort(arr,0,arr.length-1);
        print(arr);
    }

    void mergesort(int arr[], int left, int right){
        if(left < right){
            int mid = left + (right-left)/2;
            mergesort(arr, left, mid);
            mergesort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }
    
    void merge(int arr[], int left, int mid, int right){
        int n1 = mid - left +1;
        int n2 = right -mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i=0;i< n1;i++){
            L[i] = arr[left + i];
        }
        for(int j=0;j< n2;j++){
            R[j] = arr[mid+1+j];
        }
        int i=0;
        int j = 0;
        int k =left;
        while(i<n1 && j <n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
                k++;
            }
            else{
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while(i < n1){
            arr[k] = L[i];
            k++;
            i++;
        }

        while(j < n2){
            arr[k] = R[j];
            k++;
            j++;
        }

    }

    void quick(){
        int arr[] = {4,2,0,1,4,5,6,12,13};
        quicksort(arr, 0, arr.length);
        
    }
    void quicksort(int arr[], low, high){
        if(low < high){
            int index = partition(arr, low, high);
            quicksort(arr, low, index-1);
            quicksort(arr, index+1, high);
        }
    }

    int partition(arr, low, high){
        int pivot = arr[high];
        int i = low-1;
        for(int j =low;j<high;j++){
            if(arr[j]<= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[i] = pivot;
        return i+1;
    }
}

class Sort{
    public static void main(String args[]){
        Sorting sort = new Sorting();
        // sort.bubble();
        // sort.selection();
        // sort.insertion();
        sort.merge();
        // sort.quick();

    }
}