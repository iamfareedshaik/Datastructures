class SelectionSort{
    public static void main(String args[]){
        int arr [] = {2,5,10,8,11,14};
        for(int i = 0;i<arr.length;i++){
            int index = min(i, arr);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        for(int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static int min(int i, int arr[]){
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
}