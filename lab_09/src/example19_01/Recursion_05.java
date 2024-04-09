package example19_01;

public class Recursion_05 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    public static int fib(int x) {
        System.out.println("x = " + x);
        if (x == 0)
            return 0;
        else if (x == 1)
            return 1;
        else
            return fib(x - 2) + fib(x - 1);
    }
}