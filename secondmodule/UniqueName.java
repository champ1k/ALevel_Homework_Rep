import java.util.*;

public class UniqueName {
    public static String uniqueName(List<String> names) {
        if(names.isEmpty())
            throw new  IllegalArgumentException("List is empty!");
        if(names.size() == 1)
            return names.get(0);
        Map<String, Integer> map = new HashMap<>();
        names.forEach(str -> {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        });
        return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey).findFirst().map(Objects::toString).orElse(" ");
        }
}
