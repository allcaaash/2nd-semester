package Examples;

public class Example13 {
    public static void main(String[] args) {
        try {
            int l = args.length;
            System.out.println("Array size: " + l);

            int h = 10 / l;
            args[l + 1] = "10";
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Индекс не существует");
        }
    }
}
