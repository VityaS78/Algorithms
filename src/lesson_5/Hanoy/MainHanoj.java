package lesson_5.Hanoy;

import lesson_4.MyLinkedStack;

import static lesson_5.Main.involution;

public class MainHanoj {
    private static int count = 0; // счетчик перемещений
    private static int maxRingSize = 20; //50 колец мой компьютер будет обрабатывать что-то около 300 денй ):

    public static void main(String[] args) {
//        hanoj(maxRingSize, 1, 2, 3);
//        System.out.println();

        System.out.println(involution(2, maxRingSize) - 1); // вычисляем необходимое количество перемещений

        MyLinkedStack<Integer> startTower = new MyLinkedStack<>();
        MyLinkedStack<Integer> finishTower = new MyLinkedStack<>();
        MyLinkedStack<Integer> tempTower = new MyLinkedStack<>();

        fillTower(startTower);

        System.out.println();
        System.out.println("start tower :" + (startTower.size() == 0 ? null : startTower));
        System.out.println("finish tower :" + (finishTower.size() == 0 ? null : finishTower));
        System.out.println("temp tower :" + (tempTower.size() == 0 ? null : tempTower));
        System.out.println();

        long t = System.currentTimeMillis();
        runHanojTowersRec(startTower.size(), startTower, finishTower, tempTower);
        double delta = (System.currentTimeMillis() - t) / 1000.0; // время выполнения алгоритма
        System.out.println("time = " + delta);

        System.out.println("count : " + count);

        System.out.println();
        System.out.println("start tower :" + (startTower.size() == 0 ? null : startTower));
        System.out.println("finish tower :" + (finishTower.size() == 0 ? null : finishTower));
        System.out.println("temp tower :" + (tempTower.size() == 0 ? null : tempTower));
    }

    private static void runHanojTowersRec(int n, MyLinkedStack<Integer> start, MyLinkedStack<Integer> finish, MyLinkedStack<Integer> temp) {
        if (n == 0) return;
        runHanojTowersRec(n - 1, start, temp, finish);
        finish.push(start.pop());
        count++;
        runHanojTowersRec(n - 1, temp, finish, start);
    }

    private static void fillTower(MyLinkedStack tower) {
        for (int i = 0; i < maxRingSize; i++) tower.push(maxRingSize - i);
    }

//    public static void hanoj(int n, int start, int finish, int temp) {
//        if (n == 0) return;
//        hanoj(n - 1, start, temp, finish);
//        System.out.println(n + ": " + start + " -> " + finish);
//        hanoj(n - 1, temp, finish, start);
//    }
}
