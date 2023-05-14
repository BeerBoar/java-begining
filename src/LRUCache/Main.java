package LRUCache;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new Cache<>(2);
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        System.out.println(map.get(2));
        map.put(4, "four");
        System.out.println(map);
    }

}
