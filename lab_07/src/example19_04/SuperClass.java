package example19_04;

public class SuperClass {
    public char ch;

    SuperClass(char ch) {
        this.ch = ch;
    }

    SuperClass(SuperClass obj) {
        this.ch = obj.ch;
    }
}
