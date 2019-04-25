package lesson_8;

public class MyChainingHashMap<Key, Value> {
    private int M = 7;
    private int size = 0;
    private Object[] st = new Object[M];

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Ключ не может равняться null");

        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) return x.value;
            x = x.next;
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Ключ не может равняться null");
        if (value == null) throw new IllegalArgumentException("Таблица символов не может хранить Null");
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i]);
        size++;
    }

    public Value del(Key key) {
        if (key == null) throw new IllegalArgumentException("Ключ не может равняться null");
        int i = hash(key);
        Node x = (Node) st[i];
        if (key.equals(x.key)) {
            Value v = x.value;
            st[i] = x.next;
            size--;
            return v;
        } else {
            while (x != null) {
                if (key.equals(x.next.key)) {
                    Value v = x.value;
                    x.next = x.next.next;
                    size--;
                    return v;
                }
                x = x.next;
            }
        }
        return null;
    }
}
