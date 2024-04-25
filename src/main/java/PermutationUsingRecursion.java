import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationUsingRecursion {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 12, 13, 14, 15, 16, 17, 18);
        List<List<Integer>> powerSet = new LinkedList<>();
        powerSet.add(new LinkedList<>());
        var i = System.currentTimeMillis();
        int a = getRecursion(0, powerSet, list);
        var j = System.currentTimeMillis();
        System.out.println((j - i ) );
        System.out.println(a);
    }

    @SuppressWarnings("unused")
    public static void returnAllPermutation(int c, String org, String str, Set<String> strings) {
        if (c != org.length()) {
            strings.add(str);
            returnAllPermutation(c + 1, org, str, strings);
            strings.add(str + org.charAt(c));
            returnAllPermutation(c + 1, org, str + org.charAt(c), strings);
        }
    }

    public static <T> int getRecursion(int i, List<List<T>> ls, List<T> r) {
        if (i == r.size())
            return 1;
        List<List<T>> subsetsNew = new LinkedList<>();
        for (List<T> lsc : ls) {
            subsetsNew.add(new ArrayList<>(lsc));
            lsc.add(r.get(i));
        }
        ls.addAll(subsetsNew);
        return 1 + getRecursion(i + 1, ls, r);
    }
}
