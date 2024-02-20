package example19_05;

public class Main {
    public static void main(String[] args) {
        var objSuper = new SuperClass("super class");
        var objA = new SubClassA("class A", 0);
        var objB = new SubClassB("class B", '$');

        objSuper.show();
        objA.show();
        objB.show();

        SuperClass obj;

        obj = objA;
        obj.show();

        obj = objB;
        obj.show();
    }
}
