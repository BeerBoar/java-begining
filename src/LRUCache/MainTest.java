package LRUCache;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        Map<Integer, String> map = new Cache<>(2);
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        System.out.println(map.get(2));
        map.put(4, "four");
        String result = map.toString();
        Map<Integer, String> eMap = new Cache<>(2);
        eMap.put(2,"two");
        eMap.put(4, "four");
        String expected = eMap.toString();
        assertEquals(result, expected);
    }
}