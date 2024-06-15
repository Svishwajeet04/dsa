package sorting;

public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5, 7, 2};

        int inv = countInv(arr, 0, arr.length - 1);
        System.out.println(inv);
    }

    private static int countInv(int[] arr, int l, int r) {
        int res = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            res += countInv(arr, l, mid);
            res += countInv(arr, mid + 1, r);
            res += mergeArr(arr, l, r, mid);
        }
        return res;
    }

    private static int mergeArr(int[] arr, int l, int r, int mid) {
        int[] a = new int[mid - l + 1];
        int[] b = new int[r - mid];
        int res = 0;
        for (int i = l; i <= mid; i++) {
            a[i - l] = arr[i];
        }
        for (int i = mid + 1; i <= r; i++) {
            b[i - mid - 1] = arr[i];
        }
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= r) {
            if (a[i - l] <= b[j - mid - 1]) {
                arr[k] = a[i - l];
                i++;
            } else {
                res++;
                System.out.println("inversion pair :" + a[i - l] + " " + b[j - mid - 1]);
                arr[k] = b[j - mid - 1];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k++] = a[i - l];
            i++;
        }
        while (j <= r) {
            arr[k++] = b[j - mid - 1];
            j++;
        }
        return res;
    }
}
