package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 9, 23, 34, 56, 78};
        int[] b = {3, 4, 6, 9, 25, 38, 69, 75};
        Integer[] union = doUnion(a, b);
        System.out.println(Arrays.toString(union));
    }

    private static Integer[] doUnion(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int i = 0; int j = 0;
        while (i < a.length && j < b.length) {
            if(a[i] <= b[j]){
                if(list.isEmpty() || list.get(list.size() -1) != a[i]){
                    list.add(a[i]);
                }
                i++;
            }else{
                if(list.isEmpty() || list.get(list.size() -1) != b[j]){
                    list.add(b[j]);
                }
                j++;
            }
        }
        while (i <  a.length){
            if(list.isEmpty() || list.get(list.size() -1) != a[i]){
                list.add(a[i]);
            }
            i++;
        }
        while (j <  b.length){
            if(list.isEmpty() || list.get(list.size() -1) != b[j]){
                list.add(b[j]);
            }
            j++;
        }
        return list.toArray(new Integer[0]);
    }
}
