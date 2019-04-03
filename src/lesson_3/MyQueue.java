package lesson_3;

import java.util.NoSuchElementException;

public class MyQueue<Item> {
//    size
//    isEmpty
//    resize
//    enQueue
//    deQueue
//    peekFront
//    toString

    private Object[] queue = new Object[1];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(start + i) % queue.length];
        }
        queue = temp;
        start = 0;
        end = size;
    }

    public void enQueue(Item item) {
        if (size == queue.length) resize(queue.length * 2);
        queue[end] = item;
        end++;
        end %= queue.length;
        size++;
    }

    public Item deQueue() {
        if (isEmpty()) throw new NoSuchElementException("Очередь пуста");
        Item item = (Item) queue[start];
        start++;
        start %= queue.length;
        size--;
        if (size == queue.length / 4 && size > 0) resize(queue.length / 2);
        return item;
    }

    public Item peekFront() {
        if (isEmpty()) throw new NoSuchElementException("Очередь пуста");
        return (Item) queue[start];
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(queue[(start + i) % queue.length] + ", ");
        }
        return str.toString();
    }
}
