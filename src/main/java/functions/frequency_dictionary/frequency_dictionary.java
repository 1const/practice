package functions.frequency_dictionary;
import java.util.*;

public class frequency_dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.toLowerCase();
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i<str.length(); i++) {
            if (!map.containsKey(str.charAt(i)) && str.charAt(i) >= 'a' && str.charAt(i) <= 'z' ) {
                map.putIfAbsent(str.charAt(i), 1);
            } else {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
        }
        System.out.println(map.toString());
    }
}

