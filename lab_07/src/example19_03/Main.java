package example19_03;

public class Main {
    public static void main(String[] args) {
        var obj1 = new SuperClass(1);
        var obj2 = new FirstSubClass(2, '&');
        var obj3 = new SecondSubClass(3, '|', "text");

        Object ref;

        ref = obj1;
        System.out.println(ref.toString());
        obj1.setValues(11);
        System.out.println(ref.toString());

        ref = obj2;
        System.out.println(ref.toString());
        obj2.setValues(22, '^');
        System.out.println(ref.toString());

        ref = obj3;
        System.out.println(ref.toString());
        obj3.setValues(33, '%', "new text");
        System.out.println(ref.toString());
    }
}
