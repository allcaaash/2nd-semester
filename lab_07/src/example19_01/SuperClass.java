package example19_01;

public class SuperClass {
    private String line;
    SuperClass (String line) {
        this.line = line;
    }
    SuperClass () {

    }

    @Override
    public String toString() {
        String superClass;
        superClass = "Class name: " + this.getClass().getSimpleName() + "\n" +
                "line = \"" + this.getLine() + "\"" + "\n";

        return superClass;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getLine() {
        return this.line;
    }
}
