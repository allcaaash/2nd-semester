package example19_05;

public class SubClassA extends SuperClass{
    protected int num;

    SubClassA(String line, int num) {
        super(line);
        this.num = num;
    }

    @Override
    void show() {
        System.out.println("Class name: " + getClass().getSimpleName() + "; line = " + this.line +
                ", num = " + this.num);
    }
}
