package misc;

public class SnakeTraversalMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {2, 3, 5, 6},
                {7, 3, 3, 77},
                {4, 67, 0, 12},
                {6, 29, 2, 5}
        };
        for(int i = 0 ; i < arr.length; i++){
            if(i % 2 == 0){
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }else{
                for (int j = arr[0].length -1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
