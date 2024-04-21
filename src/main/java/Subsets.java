import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        String[] arr = Arrays.stream("abcd".split("")).toList().toArray(new String[0]);
        List<List<String>> list = new LinkedList<>();
        generateSubsets(list, arr);
        list.forEach(System.out::println);
    }

    private static <T> void generateSubsets(List<List<T>> list, T[] arr) {
        doGenerateSubsets(list, arr, new ArrayList<>(), 0);
    }

    private static <T> void doGenerateSubsets(List<List<T>> list, T[] arr, List<T> characters, int i) {
        if (arr.length == 0 || arr.length == i) {
            list.add(characters);
        } else {
            T atI = arr[i];
            doGenerateSubsets(list, arr, new ArrayList<>(characters), i + 1);
            characters.add(atI);
            doGenerateSubsets(list, arr, new ArrayList<>(characters) , i + 1);
        }
    }
}
