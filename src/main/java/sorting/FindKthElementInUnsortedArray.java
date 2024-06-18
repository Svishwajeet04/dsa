package sorting;

public class FindKthElementInUnsortedArray {

    public static void main(String[] args) {
        int [] arr = {10, 4, 5, 8, 11, 6 , 26};
        int element = findKthElement(arr, 5, 0, arr.length -1);
        System.out.println(element);
    }

    private static int findKthElement(int[] arr, int k, int left, int right) {
        if(k < 0 || k > arr.length){
            return Integer.MAX_VALUE;
        }else{
            int index = findPartition(arr, left, right);
            if(index == k-1){
                return arr[index];
            }else if(index > k-1){
                return findKthElement(arr, k, left, index - 1);
            }else{
                return findKthElement(arr, k , index + 1, right);
            }
        }
    }

    private static int findPartition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int j = right - 1;
        int i = left;
        while(i <= j){
            if(arr[i] < pivot){
                i++;
            }else{
                int temp = arr[j];
                arr[j] = arr[i];
                arr[j] = temp;
                j--;
            }
        }
        arr[right] = arr[i];
        arr[i] = pivot;
        return i;
    }
}
