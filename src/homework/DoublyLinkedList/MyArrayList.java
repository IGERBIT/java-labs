package homework.DoublyLinkedList;

import java.util.Arrays;
import java.util.Objects;

public final class MyArrayList implements List {
    private static final int DEFUALT_SIZE = 2;
    private int[] elements;
    private int size;
    public MyArrayList() {
        elements = new int[DEFUALT_SIZE];
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean contains(int element) {
        for (int i = 0; i < size; ++i) {
            if (element == elements[i]) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int[] toArray() {
        return Arrays.copyOf(elements, size);
    }
    @Override
    public void add(int element) {
        if (size == elements.length) {
            elements = grow();
        }
        elements[size] = element;
        ++size;
    }
    @Override
    public void add(int index, int element) {
        rengeCheckForAdd(index);
        if (size == elements.length) {
            elements = grow();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        ++size;
    }
    @Override
    public void clear() {
        elements = new int[DEFUALT_SIZE];
        size = 0;
    }
    @Override
    public int get(int index) {
        rengeCheckForGet(index);
        return elements[index];
    }
    @Override
    public int remove(int index) {
        Objects.checkIndex(index, size);
        int oldValue = elements[index];
        if (index < size - 1) {
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        }
        --size;
        return oldValue;
    }
    @Override
    public int indexOf(int element) {
        for (int i = 0; i < size; ++i) {
            if (element == elements[i]) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != this.size) {
            return false;
        }
        for (int i = 0; i < size; ++i) {
            if (list.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < size; ++i) {
            str.append(elements[i]).append(",");
        }
        str.delete(str.length() - 1, str.length());
        if (str.length() != 0) {
            str.append("]");
        }
        return str.toString();
    }
    private int[] grow() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        return Arrays.copyOf(elements, newCapacity);
    }
    private void rengeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            String massage = String.format("Index: %d, Size: %d", index, size);
            throw new IndexOutOfBoundsException(massage);
        }
    }
    private void rengeCheckForGet(int index) {
        if (index < 0 || index >= size) {
            String massage = String.format("Index: %d, Size: %d", index, size);
            throw new IndexOutOfBoundsException(massage);
        }
    }
}