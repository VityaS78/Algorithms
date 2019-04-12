package lesson_5;

public class Main {
    public static void main(String[] args) {
        int a = 2;
        int n = 15; // степень
        long result;
        result = involutionRec(a, n);
        System.out.println();
        System.out.println(result);
    }

    public static long involution(int a, int n) {
        long res = 1;
        int m = 1;
        if (n == 0) return 1;
        if ((n % 2) == 0) {
            while (m <= n / 2) {
                res *= a;
                m++;
            }
            return res * res;
        }
        while (m <= (n - 1) / 2) {
            res *= a;
            m++;
        }
        return res * res * a;
    }

    private static long involutionRec(int a, int n) {
        System.out.print(n + " ");
        if (n == 0) return 1;
        if (n == 1) return a;
        long res;
        if (n % 2 == 0) {
            res = involutionRec(a, n / 2);
            return res * res;
        } else {
            res = involutionRec(a, (n - 1) / 2);
            return res * res * a;
        }
    }
}
