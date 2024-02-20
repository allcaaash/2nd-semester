package example19_01;

public class Main {
    public static void main(String[] args) {
        var superObj = new SuperClass("line example (superObj)");
        var subObj = new SubClass("line example (subObj)");
        var subObj2 = new SubClass("line example (subObj2)", "str example");

        Object obj;

        obj = superObj;
        System.out.println(obj.toString());

        obj = subObj;
        System.out.println(obj.toString());

        obj = subObj2;
        System.out.println(obj.toString());
    }
}