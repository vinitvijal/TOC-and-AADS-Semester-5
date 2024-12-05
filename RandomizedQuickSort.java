// Write a program to sort the elements of an array using Randomized Quick Sort
public class RandomizedQuickSort {
    public static void main(String[] args) {
        int arr[] = {5, 2, 6, 1, 3, 7, 4};
        quickSort(arr, 0, arr.length-1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int arr[], int low, int high){
        if(low < high){
            int random = (int)(Math.random() * (high-low+1) + low);
            int temp = arr[random];
            arr[random] = arr[high];
            arr[high] = temp;
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
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
    
}
