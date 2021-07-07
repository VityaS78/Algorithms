package lesson_4;

public class MyLinkedStack<Item> {
    private MyLinkedList<Item> stack = new MyLinkedList<>();

    public void push(Item item) {
        stack.addFirst(item);
    }

    public Item pop() {
        return stack.removeFirst();
    }

    public Item peek() {
        return stack.getFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public String toString() { return stack.toString(); }
}
