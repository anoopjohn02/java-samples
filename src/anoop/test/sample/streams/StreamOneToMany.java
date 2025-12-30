package anoop.test.sample.streams;

import java.util.List;
import java.util.stream.Stream;

// flatMap, mapMulti
public class StreamOneToMany {
    public static void main(String[] args) {
        List<String> integerStrings = List.of("10", "20", "30", "40", "50");
        List<Integer> listIntegers = integerStrings.stream()
                .map(Integer::parseInt)
                .toList();
        System.out.println(listIntegers);

        // Assume there is an exception in map function because of "abc"
        List<String> integerStringsInvalid = List.of("10", "20","abc", "30", "40", "50");
        listIntegers = integerStringsInvalid.stream()
                .filter(s -> {
                    try {
                        Integer.parseInt(s);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .map(Integer::parseInt)
                .toList();
        System.out.println(listIntegers);

        // Use flat map and remove filter
        listIntegers = integerStringsInvalid.stream()
                .flatMap(s -> {
                    try {
                        int i = Integer.parseInt(s);
                        return Stream.of(i);
                    } catch (Exception e) {
                        Stream.empty();
                    }
                    return Stream.empty();
                })
                .toList();
        System.out.println(listIntegers);

        // Use mapMulti
        listIntegers = integerStringsInvalid.stream()
                .<Integer>mapMulti((s, consumer) -> {
                    try {
                        Integer i = Integer.parseInt(s);
                        consumer.accept(i);
                    } catch (Exception e) {}
                })
                .toList();
        System.out.println(listIntegers);
    }
}
