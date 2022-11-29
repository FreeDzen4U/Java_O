package Labs_O.Lab_5.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {

    public static void main(String[] args) throws IOException {
        String url = "https://fonts.google.com/";

        Map<String, Integer> tagCountMap = new TreeMap<>();

        StringBuilder page = new StringBuilder();

        try (Reader urlReader = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            char[] buffer = new char[1000];

            while (urlReader.read(buffer) != -1) {
                page.append(buffer);
            }
        }

        Pattern tagPattern = Pattern.compile("(?<=<)(?=.*>)[\\w-]+");

        Matcher tagMatcher = tagPattern.matcher(page);

        while (tagMatcher.find()) {
            tagCountMap.merge(tagMatcher.group(), 1, Integer::sum);
        }

        System.out.println("Task 1");
        for (Map.Entry<String, Integer> entry : tagCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        System.out.println("Task 2");
        List<TagCounter> TagOfCounters = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : tagCountMap.entrySet()) {
            TagOfCounters.add(new TagCounter(entry.getKey(), entry.getValue()));
        }
        TagOfCounters.sort(new TagCounterComparator());
        TagOfCounters.forEach(i->System.out.println(i.Tag+": "+i.Value));
    }
}
