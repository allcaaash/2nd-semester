package example19_03;

public class SuperClass {
    public int number;

    SuperClass(int number) {
        this.number = number;
    }

    public void setValues(int number) {
        this.number = number;
    }

    public String toString() {
        return "Class name: " + getClass().getSimpleName() + "; " +
                "number = " + this.number;
    }
}
