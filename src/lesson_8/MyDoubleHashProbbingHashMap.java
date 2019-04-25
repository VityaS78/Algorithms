package lesson_8;

public class MyDoubleHashProbbingHashMap<Key, Value> {
    private int M = 2;
    private int size = 0;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key, int m) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Ключ не может равняться null");
        for (int i = hash(key, M); keys[i] != null; i = (i + 1) % M) {
            if (((Key) keys[i]).equals(key)) {
                return (Value) values[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Ключ не может равняться null");
        if (value == null) throw new IllegalArgumentException("Таблица символов не может хранить Null");
        if (size == M - 1) resize(M * 2);
        put(key, value, keys, values, M);
        size++;
    }

    private void resize(int capasity) {
        Object[] tempKeys = new Object[capasity];
        Object[] tempValues = new Object[capasity];
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                put((Key)keys[i], (Value)values[i], tempKeys, tempValues, capasity);
            }
        }
        M = capasity;
        keys = tempKeys;
        values = tempValues;
    }

    private void put(Key key, Value value, Object[] tempKeys, Object[] tempValues, int m) {
        int i;
        int step = (m - 3) - key.hashCode() % (m - 3);
        for (i = hash(key, m); tempKeys[i] != null; i = (i + step) % m) {
            if (((Key) tempKeys[i]).equals(key)) {
                tempValues[i] = value;
                return;
            }
        }
        tempKeys[i] = key;
        tempValues[i] = value;
    }

    public Value del(Key key) {
        if (key == null) throw new IllegalArgumentException("Ключ не может равняться null");
        int step = (M - 3) - key.hashCode() % (M - 3);
        for (int i = hash(key, M); keys[i] != null; i = (i + step) % M) {
            if (((Key) keys[i]).equals(key)) {
                Value v = (Value) values[i];
                keys[i] = null;
                size--;
                if (size <= M / 4 && size > 0) {
                    resize(M / 2);
                } else resize(M);
                return v;
            }
        }
        return null;
    }
}
