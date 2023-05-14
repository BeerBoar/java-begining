package LRUCache;

import java.util.*;

public class Cache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    //������� ���� � ������������ �� 1 ������ ��� ����������, ����� ��� ���������� �������� �������� ��������� �����
    //removeEldestEntry (���� accessOrder = true) � ����� ������ �������� ���������. ��� ���� ���� �� ����� �������������
    //�.�. loadFactor > 1.0
    public Cache(int capacity) {
        super(capacity+1, 1.1f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //��� ���������� �������� ����� capacity ������ true � ���������� ��������
        return this.size()>capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cache<?, ?> cache = (Cache<?, ?>) o;
        return capacity == cache.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cache{" + "capacity=" + capacity +"}"+"\n");
        Set<K> set = new HashSet<>(this.keySet());
        for (K k:set){
            builder.append("Key:"+ k + " Value:" + this.get(k) + "\n");
        }
        return builder.toString();
    }
}
