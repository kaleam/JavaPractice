package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        // 1. Now, starting again from a list of names, give me the total number of letters in all the names with more than 5 letters
        //List<String> names = List.of("william", "jones", "aaron", "seppe", "frank", "gilliam");
        String[] names = new String[]{"william", "jones", "aaron", "seppe", "frank", "gilliam"};

        int sum = Arrays.stream(names).filter(n -> n.length() > 5).mapToInt(n -> n.length()).sum();
        //System.out.println(sum);

        // 2. Flatten this multidimensional collection
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        //System.out.println(collection.stream().flatMap(x -> x.stream()).collect(Collectors.toList()));

        // 3. Get the oldest person from the collection
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> people = asList(sara, eva, viktor);
        Optional<Person> person = people.stream().sorted((a,b) -> b.getAge() - a.getAge()).findFirst();
//        if(person.isPresent()) {
//            System.out.println(person.get().getName());
//        }

        // 4. Sum all elements of a collection, try to use the reduce operator with identity parameter instead of an IntStream
        List<Integer> numbers = asList(1, 2, 3, 4, 5);


        Collections.sort(numbers, (a,b) -> a - b);
        numbers.indexOf(1);

        //System.out.println(numbers.stream().mapToInt(n -> n).sum());

        // 5. Get the names of all kids under the age of 18
        Set<String> kids = people.stream().filter(p -> p.getAge() < 18).map(Person::getName).collect(Collectors.toSet());


        // 6. Partition these people into adults and kids, you'll need a special collector for this one
        Map<Boolean,List<Person>> map = people.stream().collect(Collectors.groupingBy(p -> p.getAge()>=18));

        // 7. Return a comma-separated string of all these people's names
        String name = "Names: "
                + String.join(", ",people.stream().map(p->p.getName()).collect(Collectors.toList()))
                + ".";

        //8. Challenge:
        List<Integer> list = List.of(3,44);
        String result = String.join(",", list.stream().map(n -> (n%2==0)? "e"+n : "o"+n).collect(Collectors.toList()));

        int pow = (int) Math.pow(2,3);

        // 9. Given an array A of non-negative integers, arrange them such that they form the largest number.
        List<Integer> num = List.of(3, 30, 34, 5, 0);
        long zeros = num.stream().filter(a->a==0).count();
        String largestNum = num.stream().sorted((a,b)-> Integer.parseInt(b.toString()+a.toString()) - Integer.parseInt(a.toString()+b.toString())).map(n -> n.toString()).collect(Collectors.joining(""));

        Stream<Integer> sortedStream = num.stream().sorted((a, b)->b-a);
        List<Integer> sortedList = sortedStream.collect(Collectors.toList());
        sum = num.stream().reduce(0,(a,b)->a+b);

        // 10. Longest consecutive 1s after swapping one 0
        String s = "111011101";
        List<String> sortedOnes = Arrays.stream(s.split("0")).sorted((a,b)->b.length()-a.length()).collect(Collectors.toList());
        int count = 0;
        if(sortedOnes.size() == 0)
            count = 0;
        if(sortedOnes.size() == 1)
            count = sortedOnes.get(0).length();
        if(sortedOnes.size() == 2)
            count = sortedOnes.get(0).length() + sortedOnes.get(1).length();
        if(sortedOnes.size() > 2)
            count = sortedOnes.get(0).length() + sortedOnes.get(1).length() + 1;

        String input = "aBhIjEEt", ans = "";
        for(int i=0;i<input.length();i++){
            //ans += Character.toString(Character.codePointAt(input,i) ^ 32);
        }
        System.out.println(ans);

        List<Integer> A = List.of(3,2,6);
        List<Integer> B = List.of(9,8,9);

        List<List<Integer>> merged = new ArrayList();
        merged.add(A);
        merged.add(B);

        List<List<Integer>> sorted = merged.stream().sorted((list1, list2)->list2.get(0) - list1.get(0)).collect(Collectors.toList());

    }
}
