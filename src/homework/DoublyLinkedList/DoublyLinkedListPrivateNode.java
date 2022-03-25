package homework.DoublyLinkedList;

public final class DoublyLinkedListPrivateNode {
    private final DoublyLinkedListNode publicNode;
    private DoublyLinkedList list;
    private int value;
    private DoublyLinkedListPrivateNode prev;
    private DoublyLinkedListPrivateNode next;

    public DoublyLinkedListPrivateNode(int valueValue, DoublyLinkedList listValue) {
        this.value = valueValue;
        this.list = listValue;

        publicNode = new DoublyLinkedListNode(this);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public DoublyLinkedListPrivateNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListPrivateNode value) {
        this.prev = value;
    }

    public DoublyLinkedListPrivateNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListPrivateNode value) {
        this.next = value;
    }

    public DoublyLinkedList getList() {
        return list;
    }

    public DoublyLinkedListNode getPublicNode() {
        return publicNode;
    }

    public void flush() {
        list = null;
        prev = null;
        next = null;
    }
}
