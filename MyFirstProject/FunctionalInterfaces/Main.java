package FunctionalInterfaces;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        BiPredicate<String, Integer> bi1 = new BiPredicate<String, Integer>() {
//
//            @Override
//            public boolean test(String t, Integer u) {
//                return t.length() > u;
//            }
//
//        };
//        // System.out.println(bi1.test("Scaler", 1));
//
//        BiPredicate<String, Integer> bi2 = (str, val) -> str.length() > val;
//        // System.out.println(bi2.test("Scaler", 10));
//
//        List<Integer> list = List.of(5, 1, 3, 2, 8, 6, 4);
//        System.out.println(list.stream().sorted().toList());
//        System.out.println(list.stream().filter((a) -> a % 2 == 0).sorted().toList());

        List<String> fruits = List.of("apple", "banana", "orange", "apricot");
        // find length of fruits starting with a
        List<Integer> fruitsLength = fruits
                .stream()
                .filter(a -> a.startsWith("a"))
                .mapToInt(String::length)
                .boxed().toList();

        System.out.println(fruitsLength);

    }
}
