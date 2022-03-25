package homework.DoublyLinkedList;

public final class DoublyLinkedListNode {
    private final DoublyLinkedListPrivateNode privateNode;

    public DoublyLinkedListNode(DoublyLinkedListPrivateNode privateNode) {
        this.privateNode = privateNode;
    }

    public int getValue() {
        return privateNode.getValue();
    }

    public void setValue(int value) {
        privateNode.setValue(value);
    }

    public DoublyLinkedListNode getNext() {
        if (privateNode.getNext() != null && privateNode.getNext().getPublicNode() != privateNode.getList().getHead()) {
            return privateNode.getNext().getPublicNode();
        }
        return null;

    }

    public DoublyLinkedListNode getPrev() {
        if (privateNode.getPrev() != null && privateNode.getPrev().getPublicNode() != privateNode.getList().getHead()) {
            return privateNode.getPrev().getPublicNode();
        }
        return null;
    }

    public DoublyLinkedList getList() {
        return privateNode.getList();
    }
}
