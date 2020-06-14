package ru.ifmo.collections;

import java.util.LinkedHashSet;

/**
 * Design a class which contains integers and
 * returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */

public class FirstUnique {
    int[] numbers;

    public FirstUnique(int[] numbers) {
        int length = numbers.length;
        this.numbers = new int[length];
        System.arraycopy(numbers, 0, this.numbers, 0, numbers.length);
    }

    public int showFirstUnique() {
        LinkedHashSet<Integer> linkedset = new LinkedHashSet<>();
        for (int number : this.numbers) linkedset.add(number);
        Object[] data = new Object[linkedset.size()];
        data = linkedset.toArray(data);
        int[] data2 = new int[linkedset.size()];
        for (int i = 0; i < linkedset.size(); i++) {
            data2[i] = 0;
        }
        for (int i = 0; i < this.numbers.length; i++) {
            int x = this.numbers[i];
            for (int j = 0; j < linkedset.size(); j++) {
                if (x == (int) data[j]) {
                    data2[j]++;
                }
            }
        }
        for (int i = 0; i < data2.length; i++) {
            if (data2[i] == 1) {
                return (int) data[i];
            }
        }
        return -1;
    }

    public void add(int value) {
        int newLength = this.numbers.length + 1;
        int[] newNumbers = new int[newLength];
        System.arraycopy(this.numbers, 0, newNumbers, 0, newLength - 1);
        newNumbers[newLength - 1] = value;
        this.numbers = new int[newLength];
        System.arraycopy(newNumbers, 0, this.numbers, 0, newLength);
    }
}
