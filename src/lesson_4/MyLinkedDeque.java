package lesson_4;

public class MyLinkedDeque<Item> {
    private MyLinkedList<Item> deque = new MyLinkedList<>();

    private int size() {return deque.size();}

    public boolean isEmpty() {return deque.isEmpty();}

    public void insertLeft(Item item) {deque.addLast(item);}

    public void insertRight(Item item) {deque.addFirst(item);}

    public Item removeLeft() {return deque.removeLast();}

    public Item removeRight() {return deque.removeFirst();}

    public Item peekLeft() {return deque.getLast();}

    public Item peekRight() {return deque.getFirst();}
}
