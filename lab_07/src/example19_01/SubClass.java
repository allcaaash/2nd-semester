package example19_01;

public class SubClass extends SuperClass {
    private String str;

    SubClass (String line) {
        super(line);
        this.str = "";
    }

    SubClass (String line, String str) {
        super(line);
        this.str = str;
    }

    @Override
    public String toString() {
        String subClass;
        subClass = "Class name: " + getClass().getName() + "\n" +
                "line = \"" + this.getLine() + "\"" + "\n" +
                "str = \"" + this.getStr() + "\"" + "\n";

        return subClass;
    }

    public void setStr (String str) {
        this.str = str;
    }

    public String getStr() {
        return this.str;
    }
}