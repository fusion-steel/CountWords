import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountWords {
    static String S1 = "Мама мыла-мыла-мыла раму!";
    static String S2 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. " +
            "Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt " +
            "efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor " +
            "lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

    public static List<String> getWordsSortedByFreq(@NotNull String text) {
        String[] words = text.toLowerCase().split("[^a-zа-я0-9]+");
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        String::valueOf,
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = CountWords.getWordsSortedByFreq(scan.nextLine());
        list.forEach(System.out::println);
    }
}
