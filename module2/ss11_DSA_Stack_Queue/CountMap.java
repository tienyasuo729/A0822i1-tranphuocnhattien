import java.util.Map;
import java.util.TreeMap;

public class CountMap {
    public static void main(String[] args) {
        String str = "Hello World";
        String[] strings = str.split("");
        Map<String, Integer> map = new TreeMap<>();
        for (String s : strings) {
            if (map.containsKey(s)) {
                Integer value = map.get(s);
                value++;
                map.replace(s, value);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
    }
}