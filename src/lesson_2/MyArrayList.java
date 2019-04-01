package lesson_2;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<Item> implements Iterable<Item> {

    private Object[] list = new Object[10];
    private int size = 0;

    public int size() {
        return size;
    }

    public Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    private void resize(int capasity) {
        Object[] temp = new Object[capasity];
        System.arraycopy(list, 0, temp, 0, list.length - 1);
        list = temp;
    }

    public void add(Item item) {
        if (size == list.length - 1) {
            resize(2 * list.length);
        }
        list[size] = item;
        size++;
    }

    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index == -1) return false;
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;
        if (size == list.length / 4 && size > 0) {
            resize(list.length / 2);
        }
        return true;
    }

    private int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Item item) {
        return indexOf(item) > -1;
    }

    private class MyArrayListIterator implements Iterator<Item> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            Item item = (Item) list[cursor];
            cursor++;
            return item;
        }
    }


    @Override
    public Iterator<Item> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i].toString() + ", ");
        }
        return s.toString();
    }

    public void selectionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = 1; j < size; j++) {
                if (less((Item) list[j], (Item) list[min], cmp)) {
                    min = j;
                }
            }
            exch(i, min);
        }
    }

    private void exch(int i, int j) {
        Object temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private boolean less(Item item1, Item item2, Comparator<Item> cmp) {
        return cmp.compare(item1, item2) < 0;
    }

    public void insertionSort(Comparator<Item> cmp) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item) list[j], (Item) list[j - 1], cmp)) {
                    exch(j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public void boobleSort(Comparator<Item> cmp) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (less((Item) list[j], (Item) list[i], cmp)) {
                    exch(i, j);
                }
            }
        }
    }

    public boolean binarySearch(Item item, Comparator<Item> cmp) {
        int low = 0;
        int higt = size - 1;
        while (low <= higt) {
            int mid = low + (higt - low) / 2;
            if (cmp.compare(item, (Item) list[mid]) < 0) {
                higt = mid - 1;
            } else if (cmp.compare(item, (Item) list[mid]) > 0) {
                low = mid + 1;
            } else return true;
        }
        return false;
    }
}
