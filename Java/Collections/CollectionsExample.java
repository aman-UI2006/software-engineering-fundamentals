import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Demonstrates sorting a List and looking up values in a Map. */
public class CollectionsExample {
    public static void main(String[] args) {
        List<String> languages = new ArrayList<>(List.of("Java", "C++", "Python"));
        languages.sort(Comparator.naturalOrder());
        System.out.println("Sorted languages: " + languages);

        Map<String, Integer> problemCounts = new HashMap<>();
        problemCounts.put("arrays", 12);
        problemCounts.put("graphs", 7);
        System.out.println("Array problems: " + problemCounts.getOrDefault("arrays", 0));
    }
}
