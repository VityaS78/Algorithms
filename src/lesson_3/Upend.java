package lesson_3;

import java.util.Scanner;

public class Upend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        upendString(str);
    }

    public static void upendString(String str) {
        StringBuilder sb = new StringBuilder();
        MyStack<Character> stack = new MyStack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.print(str);
        System.out.print(" ==> ");
        System.out.println(sb);
    }
}
