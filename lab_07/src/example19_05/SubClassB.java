package example19_05;

public class SubClassB extends SuperClass {
    protected char ch;

    SubClassB(String line, char ch) {
        super(line);
        this.ch = ch;
    }

    @Override
    void show() {
        System.out.println("Class name: " + getClass().getSimpleName() + "; line = " + this.line +
                ", ch = " + this.ch);
    }
}
