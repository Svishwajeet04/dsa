package recursions;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(2, "a", "b", "c");
    }

    private static void towerOfHanoi(int i,
                                     String source,
                                     String auxiliary,
                                     String destination) {
        if (i != 0) {
            towerOfHanoi(i - 1, source, destination, auxiliary);
            System.out.printf("moving from %s to %s%n", source, destination);
            towerOfHanoi(i - 1, auxiliary, source, destination);
        }
    }

}
