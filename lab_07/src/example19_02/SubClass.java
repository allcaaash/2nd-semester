package example19_02;

public class SubClass extends SuperClass {
    public int number;

    SubClass (String line, int number) {
        super(line);
        this.number = number;
    }

    @Override
    public void setLine() {
        super.setLine();
    }

    @Override
    public void setLine(String line) {
        super.setLine(line);
        this.number = super.getLineLength();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLineAndNumber (String line, int number) {
        super.setLine(line);
        this.number = number;
    }
}
