package lesson_6;

import java.util.Random;

public class Main {
    static final int TIMES = 1000000;  // Здксь непонятно: если значение 90 000 то работает, а если 100 000 то компьютер зависает
                                       // что бы это могло быть? причем это только с Character ключем
    static final int MAX_HEIGHT = 6;   // при значении меньше 6, попадаются сбалансированные деревья
                                       // заполнял 10 000 000 раз, 1 раз получилось сбаллансированное дерево при высоте 6

    public static void main(String[] args) {
        Random random = new Random();
//        MyTreeMap<Character, Integer> tree = new MyTreeMap<>();
//        char a;
//        int i;
        MyTreeMap<Integer,  Integer> tree = new MyTreeMap<>();
        int a;
        int i;
        int notBal = 0;
        int bal = 0;
        long t = System.currentTimeMillis();
        for (int j = 0; j < TIMES; j++) {
            while (tree.height() <= MAX_HEIGHT) {
                i = (random.nextInt(201) - 100);
//                a = (char)(random.nextInt(58) + 65);
                a = (random.nextInt(201) - 100);
                tree.put(a, i);
            }
            if (tree.isBalanced()) bal++;
            else notBal++;
            tree.clear();
        }
        System.out.println("Время обработки: " + (double)(System.currentTimeMillis() - t) / 1000 + " секунды");
        System.out.println("Сбалансированое " + bal + " раз из " + TIMES);
        System.out.println("Не сбалансированое " + notBal + " раз из " + TIMES);

    }
}
