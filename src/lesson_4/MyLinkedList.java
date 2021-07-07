package lesson_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<Item> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    @Override
    public Iterator<Item> iterator() {
        return new MyLinkedListIteraror();
    }

    private class MyLinkedListIteraror implements Iterator<Item> {
        Node cursor = first;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = cursor.item;
            cursor = cursor.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Node previous, Item item, Node next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Item getFirst() {
        if (isEmpty()) throw new NoSuchElementException("Лист пуст");
        return first.item;
    }

    public void addFirst(Item item) {
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        if (isEmpty()) last = first;
        else oldFirst.previous = first;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Лист пуст");
        Node second = first.next;
        Item item = first.item;
        first.next = null;
        first = second;
        size--;
        if (isEmpty()) last = null;
        else second.previous = null;
        return item;
    }

    public Item getLast() {
        if (isEmpty()) throw new NoSuchElementException("Лист пуст");
        return last.item;
    }

    public void addLast(Item item) {
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Лист пуст");
        Node previous = last.previous;
        Item item = last.item;
        last.previous = null;
        last = previous;
        size--;
        if (isEmpty()) first = null;
        else last.next = null;
        return item;
    }

    public Item get(int index) throws IndexOutOfBoundsException {
        Node current = findIndexNode(index);
        return current.item;
    }

    private Node findIndexNode(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        int currentIndex = 0;
        Node current = first;
        if (index < size / 2) {
            while (currentIndex < index) {
                current = current.next;
                currentIndex++;
            }
        } else {
            currentIndex = size - 1;
            current = last;
            while (currentIndex > index) {
                current = current.previous;
                currentIndex--;
            }
        }
        return current;
    }

    public void set(int index, Item item) throws IndexOutOfBoundsException{
        Node current = findIndexNode(index);
        current.item = item;
    }

    public Item removeIndex(int index) {
        Node current = findIndexNode(index);
        return remove(current);
    }

    public int indexOf(Item item) {
        Node current = first;
        int currentIndex = 0;
        while (current != null && !current.item.equals(item)) {
            current = current.next;
            currentIndex++;
        }
        return current != null ? currentIndex : -1;
    }

    public boolean contains(Item item) {return indexOf(item) > -1;}

    public Item removeItem(Item item) {
        Node current = first;
        while (current != null && !current.item.equals(item)) {
            current = current.next;
        }
        if (current == null) return null;
        if (current == first) return removeFirst();
        if (current == last) return removeLast();
        return remove(current);
    }

    private Item remove(Node current) {
        Node next = current.next;
        Node previous = current.previous;
        previous.next = next;
        next.previous = previous;
        size--;
        current.next = null;
        current.previous = null;
        return current.item;
    }

    public void add(int index, Item item) {
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        Node current = findIndexNode(index - 1);
        Node newNode = new Node(current, item, current.next);
        current.next.previous = newNode;
        current.next = newNode;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node current = first;
        while (current != null) {
            str.append(current.item.toString() + ", ");
            current = current.next;
        }
        return str.toString();
    }
}
