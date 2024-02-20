package example19_05;

public class SuperClass {
    protected String line;

    SuperClass(String line) {
        this.line = line;
    }

    void show() {
        System.out.println("Class name: " + getClass().getSimpleName() + "; line = " + this.line);
    }
}