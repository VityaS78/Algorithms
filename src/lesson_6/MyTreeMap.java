package lesson_6;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public void display() {
            System.out.println(key + " : " + value + "  ");
        }

        public Node(Key key, Value value, int size, int height) {
            this.size = size;
            this.value = value;
            this.key = key;
            this.height = height;
        }
    }

    private Node root = null;

    public boolean isEmpty() {
        return root == null;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int size() {
        return size(root);
    }

    private int height(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;
        return node.height;
    }

    public int height() {
        return height(root);
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node node) {
        if (key == null) throw new IllegalArgumentException("Ключ не может быть со значением Null");
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node.value;
        if (cmp < 0) return get(key, node.left);
        return get(key, node.right);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        root = put(key, value, root);
    }

    private Node put(Key key, Value value, Node node) {
        if (key == null) throw new IllegalArgumentException("Ключ не может быть со значением Null");
        if (value == null) throw new IllegalArgumentException("Значение не может быть равным Null");
        if (node == null) return new Node(key, value, 1, 0);

        int cmp = key.compareTo(node.key);

        if (cmp == 0) node.value = value;
        else if (cmp < 0) node.left = put(key, value, node.left);
        else node.right = put(key, value, node.right);

        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public Value min() {
        return min(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    public Value max() {
        return max(root).value;
    }

    private Node removeMin(Node node) {
        if (node.left == null) return node.right;
        node.left = removeMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void removeMin() {
        if (isEmpty()) throw new NoSuchElementException("Дерево пустое.");
        root = removeMin(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) return node.left;
        node.right = removeMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void removeMax() {
        if (isEmpty()) throw new NoSuchElementException("Дерево пустое.");
        root = removeMax(root);
    }

//       Реализация метода remove, который возвращает значение удаляемого узла:
//    public Value remove(Key key) {
//        if (isEmpty()) throw new NoSuchElementException("Дерево пустое.");
//        Value value = get(key, root);
//        root = remove(key, root);
//        return value;
//    }

    public void remove(Key key) {
        if (isEmpty()) throw new NoSuchElementException("Дерево пустое.");
        if (get(key) == null) {
//            System.out.println("Такой ключ отсутсвует");
            return;
        }
        root = remove(key, root);
    }

    private Node remove(Key key, Node node) {
        if (key == null) throw new IllegalArgumentException("Ключ не может быть со значением Null");
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node tmp = node;
            node = max(node.left);
            node.left = removeMax(tmp.left);
            node.right = tmp.right;
            tmp = null;
        } else if (cmp > 0) {
            node.right = remove(key, node.right);
        } else node.left = remove(key, node.left);

        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (Math.abs(height(node.left) - height(node.right)) > 1) return false;
        if (!isBalanced(node.left)) return false;
        else return isBalanced(node.right);
    }

    public void clear() {
        while (!isEmpty()) removeMin();
    }
}


