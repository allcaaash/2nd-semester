package example19_03;

public class FirstSubClass extends SuperClass{
    public char symbol;

    FirstSubClass (int number, char symbol) {
        super(number);
        this.symbol = symbol;
    }

    public void setValues(int number, char symbol) {
        super.setValues(number);
        this.symbol = symbol;
    }

    public String toString() {
        return "Class name: " + getClass().getSimpleName() + "; " +
                "number = " + this.number + ", symbol = " + this.symbol;
    }
}
