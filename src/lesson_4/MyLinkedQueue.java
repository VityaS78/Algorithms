package lesson_4;

public class MyLinkedQueue<Item> {
    private MyLinkedList<Item> queue = new MyLinkedList<>();

    public int size() {return queue.size();}

    public boolean isEmpty() {return queue.isEmpty();}

    public void enQueue(Item item) {queue.addLast(item);}

    public Item deQueue() {return queue.removeFirst();}

    public Item peekFront() {return queue.getFirst();}
}
