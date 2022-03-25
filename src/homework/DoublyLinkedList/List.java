package homework.DoublyLinkedList;

public interface List {
    int size();

    boolean isEmpty();

    boolean contains(int o);

    int[] toArray();

    void add(int e);

    void add(int index, int element);

    void clear();

    boolean equals(Object o);

    String toString();

    int get(int index);

    int remove(int index);

    int indexOf(int o);
}
