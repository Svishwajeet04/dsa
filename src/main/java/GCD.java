public class GCD {

    public static void main(String[] args) {
        int a = 16;
        int b = 4;

        System.out.println(gcd(a,b));
    }

    private static int gcd(int i, int j) {
        if(j == 0){
            return i;
        }
        return gcd(j , i % j);
    }
}
