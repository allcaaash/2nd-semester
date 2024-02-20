package example19_03;

public class SecondSubClass extends FirstSubClass {
    public String line;

    SecondSubClass (int number, char symbol, String line) {
        super(number, symbol);
        this.line = line;
    }

    public void setValues (int number, char symbol, String line) {
        super.setValues(number, symbol);
        this.line = line;
    }

    public String toString() {
        return "Class name: " + getClass().getSimpleName() + "; " +
                "number = " + this.number + ", symbol = " + this.symbol + ", line = " + this.line;
    }
}
