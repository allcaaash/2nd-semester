package example19_04;

public class FirstSubClass extends SuperClass {
    public String str;

    FirstSubClass(char ch, String str) {
        super(ch);
        this.str = str;
    }

    FirstSubClass(FirstSubClass obj) {
        super(obj.ch);
        this.str = obj.str;
    }
}
