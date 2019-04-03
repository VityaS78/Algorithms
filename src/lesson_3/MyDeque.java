package lesson_3;

import java.util.NoSuchElementException;

public class MyDeque<Item> {
    private Object[] deque = new Object[1];
    private int size = 0;
    private int leftEnd = 0;
    private int rightEnd = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void rezise(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = deque[(rightEnd + i) % deque.length];
        }
        deque = temp;
        rightEnd = 0;
        leftEnd = size;
    }

    public void insertLeft(Item item) {
        if (size == deque.length) rezise(deque.length * 2);
        deque[leftEnd] = item;
        leftEnd++;
        leftEnd %= deque.length;
        size++;
    }

    public void insertRigth(Item item) {
        if (size == deque.length) rezise(deque.length * 2);
        rightEnd = ((rightEnd + deque.length) - 1) % deque.length;
        deque[rightEnd] = item;
        size++;
    }

    public Item removeLeft() {
        if (isEmpty()) throw new NoSuchElementException("Дек пуст");
        leftEnd = ((leftEnd + deque.length) - 1) % deque.length;
        Item item = (Item) deque[leftEnd];
        size--;
        if (size == deque.length / 4 && size > 0) rezise(deque.length / 2);
        return item;
    }

    public Item removeRigth() {
        if (isEmpty()) throw new NoSuchElementException("Дек пуст");
        Item item = (Item) deque[rightEnd];
        rightEnd++;
        rightEnd %= deque.length;
        size--;
        if (size == deque.length / 4 && size > 0) rezise(deque.length / 2);
        return item;
    }

    public Item peekLeft() {
        if (isEmpty()) throw new NoSuchElementException("Дек пуст");
        return (Item) deque[((leftEnd + deque.length) - 1) % deque.length];
    }

    public Item peekRight() {
        if (isEmpty()) throw new NoSuchElementException("Дек пуст");
        return (Item) deque[rightEnd];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            str.append(deque[(rightEnd + i) % deque.length] + ", ");
        }
        return str.toString();
    }
}