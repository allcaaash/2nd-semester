package example19_01;

public class Recursion_04 {
    public static int factorial(int x) {
        if (x == 1)
            return 1;
        else
            return factorial(x - 1) * x;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
