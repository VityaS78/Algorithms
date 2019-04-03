package lesson_2;

import java.text.MessageFormat;
import java.util.Random;

public class Main {
    final static int LIST_SIZE = 1000000;
    final static int TIMES_SORT = 30;
    final static int RANGE = 100000;

    public static void main(String[] args) {
        long a;
        long b;
        long time;
        MyArrayList<Integer> list = new MyArrayList<>();

        fillArr(list);

        MyArrayList<Double> listBoobleSort = new MyArrayList<>();
        for (int i = 0; i < TIMES_SORT; i++) {
            reFillArr(list);
            a = System.currentTimeMillis();
            list.boobleSort(Integer::compareTo);
            b = System.currentTimeMillis();
            time = b - a;
            listBoobleSort.add((double) time / 1000);
        }

        MyArrayList<Double> listSelectSort = new MyArrayList<>();
        for (int i = 0; i < TIMES_SORT; i++) {
            reFillArr(list);
            a = System.currentTimeMillis();
            list.selectionSort(Integer::compareTo);
            b = System.currentTimeMillis();
            time = b - a;
            listSelectSort.add((double) time / 1000);
        }

        MyArrayList<Double> listInsertSort = new MyArrayList<>();
        for (int i = 0; i < TIMES_SORT; i++) {
            reFillArr(list);
            a = System.currentTimeMillis();
            list.insertionSort(Integer::compareTo);
            b = System.currentTimeMillis();
            time = b - a;
            listInsertSort.add((double) time / 1000);
        }

        String str = "    | вставками | выборочная | пузырьковая ";
        System.out.println(str);
        for (int i = 0; i < TIMES_SORT; i++) {
            str = MessageFormat.format(
                    " {0}  |   {1}   |   {2}   |   {3}   ",
                    i + 1,
                    listInsertSort.get(i),
                    listSelectSort.get(i),
                    listBoobleSort.get(i)
            );
            System.out.println(str);
        }
        str = MessageFormat.format(
                "    |   {0}   |   {1}   |   {2}   ",
                findAverageValue(listInsertSort),
                findAverageValue(listSelectSort),
                findAverageValue(listBoobleSort)
        );
        System.out.println(str);
    }

    private static void fillArr(MyArrayList<Integer> list) {
        int a;
        for (int i = 0; i < LIST_SIZE; i++) {
            a = new Random().nextInt(RANGE);
            list.add(a);
        }
    }

    private static void reFillArr(MyArrayList<Integer> list) {
        int a;
        for (int i = 0; i < list.size(); i++) {
            a = new Random().nextInt(RANGE);
            list.set(i, a);
        }
    }

    private static double findAverageValue(MyArrayList<Double> list) {
        double sum = 0;
        for (double e : list) {
            sum += e;
        }
        return sum / list.size();
    }
}
