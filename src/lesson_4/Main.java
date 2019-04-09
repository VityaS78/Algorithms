package lesson_4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        for (char i = 97; i < 122; i++) {
            list.addFirst(i);
            i++;
            list.addLast(i);
        }
        System.out.println(list.size());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.toString());
        list.removeIndex(10);
        list.removeItem('f');
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        list.set(20, 'j');
        System.out.println(list.size());
        System.out.println(list.get(15));
        System.out.println(list.contains('f'));
        System.out.println(list.indexOf('l'));
        list.add(12, 'q');
        System.out.println(list.get(12));
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains('S'));
        System.out.println(list.indexOf('5'));
        for (Character l: list) {
            System.out.print(l);
            System.out.print(l);
            System.out.print(l);
            System.out.print(" ");
        }
    }
}
