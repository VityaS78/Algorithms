package lesson_3;

public class Main {

    public static void main(String[] args) {
        MyDeque<Character> deque = new MyDeque<>();
        deque.insertLeft('a');
        deque.insertLeft('b');
        deque.insertRigth('c');
        deque.insertLeft('d');
        deque.insertRigth('e');
        deque.insertRigth('f');
        deque.insertLeft('g');

        System.out.println(deque.size());
        System.out.println(deque);
        System.out.println(deque.peekRight());
        System.out.println(deque.peekLeft());

        deque.removeLeft();
        System.out.println(deque.size());
        deque.removeRigth();
        deque.removeLeft();
        System.out.println(deque);
        System.out.println(deque.removeRigth());
        System.out.println(deque);
    }
}
