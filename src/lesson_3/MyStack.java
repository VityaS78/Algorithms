package lesson_3;

import java.util.NoSuchElementException;

public class MyStack<Item> {
//    size
//    isEmpty
//    resize
//    push
//    peek
//    pop
//    toString
    private Object[] stack = new Object[1];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        System.arraycopy(stack, 0, temp, 0, size);
//        for (int i = 0; i < size; i++) {
//            temp[i] = stack[i];
//        }
        stack = temp;
    }

    public void push(Item item) {
        if (size == stack.length) {
            resize(stack.length * 2);
        }
        stack[size] = item;
        size++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Стек пуст");
        Item temp = (Item) stack[size - 1];
        size--;
        if (size == stack.length / 4 && size > 0) resize(stack.length / 2);
        return temp;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Стек пуст");
        return (Item) stack[size - 1];
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) str.append(stack[i] + ", ");
        return str.toString();
    }
}
