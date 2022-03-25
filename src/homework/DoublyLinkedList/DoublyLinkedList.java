package homework.DoublyLinkedList;

public class DoublyLinkedList implements List {

    private DoublyLinkedListPrivateNode head;
    private int count;

    public DoublyLinkedListNode getEnd() {
        return head != null && head.getPrev() != null ? head.getPrev().getPublicNode() : null;
    }

    public DoublyLinkedListNode getHead() {
        return head != null ? head.getPublicNode() : null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(int o) {
        return find(o) != null;
    }

    @Override
    public int[] toArray() {
        DoublyLinkedListPrivateNode node = head;
        if (node == null) {
            return new int[0];
        }

        int[] array = new int[count];
        int index = 0;

        do {
            array[index++] = node.getValue();
            node = node.getNext();
        } while (node != head);

        return array;
    }

    @Override
    public void add(int e) {
        addLast(e);
    }

    @Override
    public void add(int index, int element) {
        checkIndexForAdd(index);
        if (index == 0) {
            addFirst(element);
        } else {
            addAfter(getAt(index - 1), element);
        }
    }

    @Override
    public void clear() {
        DoublyLinkedListPrivateNode node = head;
        while (node != null) {
            DoublyLinkedListPrivateNode temp = node;
            node = node.getNext();
            temp.flush();
        }
        head = null;
        count = 0;
    }

    @Override
    public int get(int index) {
        return getAt(index).getValue();
    }

    @Override
    public int remove(int index) {
        DoublyLinkedListPrivateNode node = getAt(index);
        remove(node);

        return node.getValue();
    }

    @Override
    public int indexOf(int value) {
        int index = 0;

        DoublyLinkedListPrivateNode node = head;
        if (node == null) {
            return -1;
        }

        while (node.getValue() != value) {
            node = node.getNext();
            index++;
            if (node == head) {
                return -1;
            }
        }

        return index;
    }


    public void addLast(int value) {
        DoublyLinkedListPrivateNode node = new DoublyLinkedListPrivateNode(value, this);
        if (head == null) {
            insertNodeToEmptyList(node);
        } else {
            insertNodeBefore(head, node);
        }
    }

    public void addFirst(int value) {
        DoublyLinkedListPrivateNode node = new DoublyLinkedListPrivateNode(value, this);
        if (head == null) {
            insertNodeToEmptyList(node);
        } else {
            insertNodeBefore(head, node);
            head = node;
        }
    }

    private void addAfter(DoublyLinkedListPrivateNode node, int value) {
        DoublyLinkedListPrivateNode newNode = new DoublyLinkedListPrivateNode(value, this);
        insertNodeBefore(node.getNext(), newNode);
    }

    public DoublyLinkedListNode find(int value) {
        DoublyLinkedListPrivateNode node = head;
        if (node == null) {
            return null;
        }

        while (node.getValue() != value) {
            node = node.getNext();
            if (node == head) {
                return null;
            }
        }

        return node.getPublicNode();
    }

    private void remove(DoublyLinkedListPrivateNode node) {
        if (node == node.getNext()) {
            head = null;
        } else {
            if (node.getNext() != null) {
                node.getNext().setPrev(node.getPrev());
            }
            if (node.getPrev() != null) {
                node.getPrev().setNext(node.getNext());
            }

            if (head == node) {
                head = node.getNext();
            }
        }
        node.flush();
        count--;
    }

    private DoublyLinkedListPrivateNode getAt(int index) {
        checkIndex(index);

        DoublyLinkedListPrivateNode node = head;

        for (; index > 0; index--) {
            node = node.getNext();
        }

        return node;
    }


    private void insertNodeToEmptyList(DoublyLinkedListPrivateNode node) {
        node.setNext(node);
        node.setPrev(node);
        head = node;
        count++;
    }

    private void insertNodeBefore(DoublyLinkedListPrivateNode node, DoublyLinkedListPrivateNode newNode) {
        newNode.setNext(node);
        newNode.setPrev(node.getPrev());
        if (node.getPrev() != null) {
            node.getPrev().setNext(newNode);
        }
        node.setPrev(newNode);
        count++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
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
        if (list.size() != count) {
            return false;
        }
        for (int i = 0; i < count; ++i) {
            if (list.get(i) != get(i)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        DoublyLinkedListPrivateNode node = head;

        if (node == null) {
            return "";
        }

        do {
            str.append(node.getValue()).append(",");
            node = node.getNext();
        } while (node != head);

        str.delete(str.length() - 1, str.length()).append("]");

        return str.toString();
    }

}
