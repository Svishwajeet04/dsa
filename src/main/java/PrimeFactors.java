public class PrimeFactors {

    public static void main(String[] args) {
        int n = 75;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                while (n % i == 0) {
                    System.out.println(i);
                    n = n / i;
                }
            }
        }
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j * j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
