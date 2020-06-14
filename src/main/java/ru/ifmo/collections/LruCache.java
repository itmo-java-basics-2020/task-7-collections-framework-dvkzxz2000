package ru.ifmo.collections;

import java.util.Map;
import java.util.LinkedHashMap;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {

    private LinkedHashMap<K, V> kvMap;

    public LruCache(int x) {
        kvMap = new LinkedHashMap<>(x, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> y) {
                return size() > x;
            }
        };
    }

    public V get(K key) {
        return kvMap.get(key);
    }

    public void put(K key, V value) {
        kvMap.put(key, value);
    }

    public int elements() {
        return kvMap.size();
    }
}