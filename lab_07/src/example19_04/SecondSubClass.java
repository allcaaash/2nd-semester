package example19_04;

public class SecondSubClass extends FirstSubClass {
    public int num;

    SecondSubClass(char ch, String str, int num) {
        super(ch, str);
        this.num = num;
    }

    SecondSubClass(SecondSubClass obj) {
        super(obj.ch, obj.str);
        this.num = obj.num;
    }
}
