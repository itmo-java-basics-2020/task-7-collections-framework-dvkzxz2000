package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {

    private TreeMap<T, Object> treeMap;

    public SortedSet(Comparator<T> comparator) {
        this.treeMap = new TreeMap<>(comparator);
    }

    public static <T> SortedSet<T> create() {
        return new SortedSet<T>(null);
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<T>(comparator);
    }

    public Collection<T> getSorted() {
        return new ArrayList<>(treeMap.keySet());
    }

    public Collection<T> getReversed() {
        return new ArrayList<>(treeMap.descendingKeySet());
    }

    @Override
    public Iterator<T> iterator() {
        return treeMap.keySet().iterator();
    }

    @Override
    public int size() {
        return treeMap.size();
    }

    @Override
    public boolean add(T t) {
        if(treeMap.put(t, new Object()) == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean torf = false;
        for (T i : collection) {
            if (add(i)) {
                torf = true;
            }
        }
        return torf;
    }

    @Override
    public boolean remove(Object object) {
        if(treeMap.remove(object) == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean torf = false;
        for (Object i : collection) {
            if (remove(i)) {
                torf = true;
            }
        }
        return torf;
    }
}
