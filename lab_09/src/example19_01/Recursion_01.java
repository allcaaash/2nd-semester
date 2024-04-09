package example19_01;public class Recursion_01 {

    public static void recursion(int x) {
        System.out.println("x= " + x);
        if ((2 * x + 1) < 20)
            recursion(2 * x + 1);
    }
    public static void main(String[] args) {
        recursion(1);
    }
}
