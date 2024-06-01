package maths;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TripletSum {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1 ,6, 5, 3, 2,5, 0, 5, 6, 0 , 0 };
        System.out.println(tripletSum(arr, 5));
    }

    public static  List<List<Integer>> tripletSum(int[] arr, int num) {
        //Your code goes here
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int i = 0;
        List<List<Integer>> list = new LinkedList<>();
        while(i < (arr.length - 2)){
            int j = i + 1;
            int k = arr.length - 1;
            while(j < k){
                int sum  = arr[i] + arr[j] + arr[k];
                if(sum == num){
                    System.out.println("equal");
                    int ak = arr[k];
                    int aj = arr[j];
                    int ck = 1;
                    int cj = 1;
                    while(arr[--k] == ak){
                        ck++;
                    }
                    while(arr[++j] == aj){
                        cj++;
                    }
                    for(int m = 0 ; m < (ck * (cj)); m++){
                        list.add(List.of(arr[i] ,arr[j - 1 ], arr[k + 1]));
                    }
                }else if(sum > num){
                    System.out.println("decreasing " +  arr[i] + " " + arr[j] + " " +  arr[k]);
                    k--;
                }else{
                    System.out.println("increasing " +  arr[i] + " " + arr[j] + " " +  arr[k]);
                    j++;
                }
            }
            i++;
        }
        return list;
    }
}
