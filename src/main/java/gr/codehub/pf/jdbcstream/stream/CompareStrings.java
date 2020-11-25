package gr.codehub.pf.jdbcstream.stream;

import java.util.*;
import java.util.stream.Collectors;

public class CompareStrings {

    private static void showStr(String text, List<String> strings) {
        System.out.println("\n=========== " + text + " ============");
        strings.forEach(s -> System.out.println(s));
    }

    private static void showStr(String text, String value) {
        System.out.println("\n=========== " + text + " ============");
        System.out.println(value);
    }

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("eve1");
        strings.add("carol1");
        strings.add("alice1");
        strings.add("bob1");
        strings.add("dave1");

        showStr("strings", strings);

        // create and terminating
        List<String> noChanges = strings
                .stream()
                .collect(Collectors.toList());
        showStr("noChanges", noChanges);

        //filter
        List<String> filterList = strings
                .stream()
                .filter(item -> item.contains("e"))
                .collect(Collectors.toList());
        showStr("filterList", filterList);

        //mapping
        List<String> mappedList = strings
                .stream()
                .map(item -> item.toUpperCase())
                .collect(Collectors.toList());
        showStr("mappedList", mappedList);

        //mapping
        List<String> remappedList = strings
                .stream()
                .map(item -> item.length())
                .map(item -> "The length is " + item)
                .map(item -> item.toUpperCase())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        showStr("remappedList", remappedList);

        //limiting results
        List<String> limitedList = strings
                .stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        showStr("limitedList", limitedList);

        // reverse sort string
        List<String> sortedStringsReversed = strings
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
        showStr("sortedStringsReversed", sortedStringsReversed);

        // create a new List
        List<String> upperCaseList = strings
                .stream()
                .map(item -> item.toUpperCase())
                .collect(Collectors.toList());
        showStr("upperCaseList", upperCaseList);

        // to get the third item
        String thirdName = strings.stream()
                .skip(2)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        showStr("thirdName", thirdName);

        // to get a specific name
        String specificItem = strings.stream()
                .filter(item -> item.equalsIgnoreCase("carol1"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        showStr("specificItem", specificItem);

        Optional<String> findFirstString = strings
                .stream()
                .findFirst();
        showStr("findFirstString", findFirstString.get());

        try {
            String findFirstStringException = strings
                    .stream()
                    .findFirst()
                    .orElseThrow(() -> new Exception());
            showStr("findFirstStringException", findFirstStringException);
        } catch (Exception e) {
            showStr("findFirstStringException", "Exception!");
            e.printStackTrace();
        }

    }
}
