package example19_02;

public class SuperClass {
    private String line;

    SuperClass (String line) {
        this.line = line;
    }

    public void setLine() {
        this.line = "";
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getLineLength() {
        return this.line.length();
    }
}
